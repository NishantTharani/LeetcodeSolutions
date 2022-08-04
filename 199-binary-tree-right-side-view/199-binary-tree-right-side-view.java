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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        if (root == null)
            return out;
        
        Queue<TreeNode> level = new LinkedList<>();
        TreeNode curr = null;
        level.add(root);
        
        while (!level.isEmpty()) {
            int n = level.size();
            
            for (int i = 0; i < n; i++) {
                curr = level.poll();
                if (curr.left != null)
                    level.add(curr.left);
                if (curr.right != null)
                    level.add(curr.right);
            }
            
            out.add(curr.val);
        }
        
        return out;
        
    }
}




