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
    int target;
    
    public int pathSum(TreeNode root, int targetSum) {
        this.target = targetSum;
        
        if (root == null)
            return 0;
        
        return recPathSum(root, 0, 0, new ArrayList<Integer>());
                
    }
    
    private int recPathSum(TreeNode curr, int sum, int out, List<Integer> path) {
        sum += curr.val;
        if (sum == this.target)
            out++;
        
        for (int i = 0; i < path.size(); i++) {
            if (sum - path.get(i) == this.target)
                out++;
        }
        
        path.add(sum);
        
        if (curr.left != null)
            out += recPathSum(curr.left, sum, 0, path);
        
        if (curr.right != null)
            out +=recPathSum(curr.right, sum, 0, path);
        
        path.remove(path.size() - 1);
        return out;
    }
}