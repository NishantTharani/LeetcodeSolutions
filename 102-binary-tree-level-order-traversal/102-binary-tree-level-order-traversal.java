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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> out = new ArrayList<>();
        
        if (root == null)
            return out;
        
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        
        TreeNode curr;
        int n;
        while (queue.size() > 0) {
            List<Integer> level = new ArrayList<>();
            n = queue.size();
            
            for (int i = 0; i < n; i++) {
                curr = queue.poll();
                level.add(curr.val);
                if (curr.left != null)
                    queue.addLast(curr.left);
                if (curr.right != null)
                    queue.addLast(curr.right);
            }
            
            out.add(level);
        }
        
        return out;
    }
}