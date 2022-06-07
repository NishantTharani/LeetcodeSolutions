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
    
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        
        this.out = 0;
        
        recDiameter(root);
        
        return this.out;
    }
    
    private int recDiameter(TreeNode curr) {
        if (curr.left == null && curr.right == null) {
            return 1;
        }
        
        int left = 0;
        int right = 0;
        
        if (curr.left != null)
            left = recDiameter(curr.left);
        
        if (curr.right != null)
            right = recDiameter(curr.right);
        
        this.out = Math.max(this.out, left + right);
        
        return Math.max(left, right) + 1;
    }
}