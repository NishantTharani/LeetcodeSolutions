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
        
        TreeNode endOfLevel = root;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(endOfLevel);
        
        TreeNode curr;
        TreeNode mostRecentlyAdded;
        
        while (endOfLevel != null) {
            List<Integer> level = new ArrayList<>();
            mostRecentlyAdded = null;
            
            do {
                curr = queue.poll();
                level.add(curr.val);
                
                if (curr.left != null) {
                    queue.add(curr.left);
                    mostRecentlyAdded = curr.left;
                }
                
                if (curr.right != null) {
                    queue.add(curr.right);
                    mostRecentlyAdded = curr.right;
                }
            } while (curr != endOfLevel);
            
            endOfLevel = mostRecentlyAdded;
            out.add(level);
        }
        
        return out;
    }
}