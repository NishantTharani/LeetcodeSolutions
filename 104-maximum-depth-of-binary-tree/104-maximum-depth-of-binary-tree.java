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
    public int maxDepth(TreeNode root) {
        return rec(root);
    }
    
    private int rec(TreeNode curr) {
        if (curr == null)
            return 0;
        
        int goLeft = 0;
        int goRight = 0;
        
        if (curr.left != null)
            goLeft = rec(curr.left);
        
        if (curr.right != null)
            goRight = rec(curr.right);
        
        return Math.max(goLeft, goRight) + 1;
    }
}