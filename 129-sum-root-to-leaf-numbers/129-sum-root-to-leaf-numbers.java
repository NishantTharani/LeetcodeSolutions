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
    public int sumNumbers(TreeNode root) {
        
        if (root == null)
            return 0;
        
        return recSumNumbers(root, 0, 0);
    }
    
    private int recSumNumbers(TreeNode currNode, int out, int sum) {
        if (currNode.left == null && currNode.right == null)
            return sum*10 + currNode.val;
        
        int left = 0;
        int right = 0;
        
        if (currNode.left != null)
            left = recSumNumbers(currNode.left, out, sum*10 + currNode.val);
        
        if (currNode.right != null)
            right = recSumNumbers(currNode.right, out, sum*10 + currNode.val);
        
        return out + left + right;
    }
}