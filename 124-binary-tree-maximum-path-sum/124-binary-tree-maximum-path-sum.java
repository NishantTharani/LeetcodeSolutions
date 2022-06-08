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
    int out;
    
    public int maxPathSum(TreeNode root) {
        this.out = root.val;
        
        recPath(root);
        return this.out;
    }
    
    private int recPath(TreeNode curr) {
        if (curr.left == null && curr.right == null) {
            this.out = Math.max(this.out, curr.val);
            return curr.val;
        }
        
        int left = 0;
        int right = 0;
        
        if (curr.left != null) {
            left = Math.max(0, recPath(curr.left));
        }
        
        if (curr.right != null) {
            right = Math.max(0, recPath(curr.right));
        }
                
        this.out = Math.max(this.out, left + right + curr.val);
        
        return Math.max(left, right) + curr.val;
    }
}