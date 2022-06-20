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
        return recGenerate(1, n);
    }
    
    public List<TreeNode> recGenerate(int left, int right) {
        
        if (right - left < 0) {
            List<TreeNode> nullOut = new ArrayList<TreeNode>();
            nullOut.add(null);
            return nullOut;
        }
        
        List<TreeNode> out = new ArrayList<>();
        
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftTrees = recGenerate(left, i-1);
            List<TreeNode> rightTrees = recGenerate(i+1, right);
            
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