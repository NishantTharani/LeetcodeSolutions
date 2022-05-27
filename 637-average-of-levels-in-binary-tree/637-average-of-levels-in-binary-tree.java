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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> out = new ArrayList<>();
        
        if (root == null)
            return out;
        
        Queue<TreeNode> queue = new LinkedList<>();
        int n;
        queue.add(root);
        TreeNode curr;
        
        while (queue.size() > 0) {
            n = queue.size();
            Double tmp = 0.0;
            
            for (int i = 0; i < n; i++) {
                curr = queue.poll();
                tmp += curr.val;
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            
            tmp /= n;
            out.add(tmp);
        }
        
        return out;
    }
}