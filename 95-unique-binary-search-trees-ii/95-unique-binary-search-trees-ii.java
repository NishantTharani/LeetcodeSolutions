/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        Map<Pair<Integer, Integer>, List<TreeNode>> memory = new HashMap<>();
        return recGenerate(1, n, memory);
    }
    
    public List<TreeNode> recGenerate(int left, int right, Map<Pair<Integer, Integer>, List<TreeNode>> memory) {
        
        if (right - left < 0) {
            List<TreeNode> nullOut = new ArrayList<TreeNode>();
            nullOut.add(null);
            memory.put(new Pair<Integer, Integer>(left, right), nullOut);
            return nullOut;
        }
        
        List<TreeNode> out = new ArrayList<>();
        
        for (int i = left; i <= right; i++) {
            Pair<Integer, Integer> leftPair = new Pair<>(left, i-1);
            List<TreeNode> leftTrees;
            if (memory.containsKey(leftPair)) {
                leftTrees = memory.get(leftPair);
            } else {
                leftTrees = recGenerate(left, i-1, memory);
                memory.put(leftPair, leftTrees);
            }
            
            Pair<Integer, Integer> rightPair = new Pair(i+1, right);
            List<TreeNode> rightTrees;
            if (memory.containsKey(rightPair)) {
                rightTrees = memory.get(rightPair);
            } else {
                rightTrees = recGenerate(i+1, right, memory);
                memory.put(rightPair, rightTrees);
            }
            
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    out.add(root);
                }
            }

        }
        
        return out;
    }
}