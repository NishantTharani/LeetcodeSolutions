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
    int target;
    
    public int pathSum(TreeNode root, int targetSum) {
        this.out = 0;
        this.target = targetSum;
        
        if (root == null)
            return out;
        
        recPathSum(root, 0, new ArrayList<Integer>());
        
        return this.out;
        
    }
    
    private void recPathSum(TreeNode curr, int sum, List<Integer> path) {
        sum += curr.val;
        if (sum == this.target)
            this.out++;
        
        for (int i = 0; i < path.size(); i++) {
            if (sum - path.get(i) == this.target)
                this.out++;
        }
        
        path.add(sum);
        
        if (curr.left != null)
            recPathSum(curr.left, sum, path);
        
        if (curr.right != null)
            recPathSum(curr.right, sum, path);
        
        path.remove(path.size() - 1);
    }
}