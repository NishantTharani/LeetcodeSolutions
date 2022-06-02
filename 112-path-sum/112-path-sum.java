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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        
        return recHasPathSum(root, targetSum, 0);
        
    }
    
    private boolean recHasPathSum(TreeNode curr, int target, int sum) {
        if (curr.left == null && curr.right == null) {
            if (sum + curr.val == target) {
                return true;
            } else {
                return false;
            }
        }
        
        boolean out = false;
        
        if (curr.left != null) {
            out = out || recHasPathSum(curr.left, target, sum + curr.val);
        }
        
        if (curr.right != null) {
            out = out || recHasPathSum(curr.right, target, sum + curr.val);
        }
        
        return out;
    }
}