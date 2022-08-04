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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        
        TreeNode parent = root;
        TreeNode curr = root;

        while (curr !=  null) {
            parent = curr;
            if (val < parent.val)
                curr = parent.left;
            else
                curr = parent.right;
        }
        
        if (val < parent.val)
            parent.left = new TreeNode(val);
        else
            parent.right = new TreeNode(val);
        
        return root;
        
    }
}


