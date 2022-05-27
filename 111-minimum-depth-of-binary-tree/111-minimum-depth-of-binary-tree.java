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
    public int minDepth(TreeNode root) {
        int out = 0;
        if (root == null)
            return out;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int n;
        TreeNode curr;
        
        while (queue.size() > 0) {
            n = queue.size();
            out++;
            
            for (int i = 0; i < n; i++) {
                curr = queue.poll();
                
                if (curr.left == null && curr.right == null)
                    return out;
                
                if (curr.left != null)
                    queue.add(curr.left);
                
                if (curr.right != null)
                    queue.add(curr.right);
                
            }
        }
        
        return -1;
    }
}