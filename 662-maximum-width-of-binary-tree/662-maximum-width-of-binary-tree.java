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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        
        Queue<Pair<TreeNode,Integer>> q = new LinkedList<>();
        q.add(new Pair<TreeNode,Integer>(root,0));
        int out = 1;
        
        while (!q.isEmpty()) {
            int n = q.size();
            Pair<TreeNode,Integer> head = q.peek();
            Pair<TreeNode,Integer> pair = null;
            
            for (int i = 0; i < n; i++) {
                pair = q.poll();
                TreeNode curr = pair.getKey();
                Integer val = pair.getValue();

                
                if (curr.left != null) {
                    q.add(new Pair<TreeNode,Integer>(curr.left, val*2));
                }
                    
                if (curr.right != null) {
                    q.add(new Pair<TreeNode,Integer>(curr.right, val*2+1));
                }
            }
            
            out = Math.max(out, pair.getValue() - head.getValue() + 1);
        }
        
        return out;
    }
}