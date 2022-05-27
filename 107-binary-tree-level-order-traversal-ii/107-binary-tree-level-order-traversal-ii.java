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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> out = new LinkedList<>();
        
        if (root == null)
            return out;
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int n;
        TreeNode curr;
        
        while (queue.size() > 0) {
            n = queue.size();
            List<Integer> tmp = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                curr = queue.poll();
                tmp.add(curr.val);
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            
            out.add(0, tmp);
        }
        
        return out;
    }
}