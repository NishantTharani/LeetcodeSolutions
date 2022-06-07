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
        if (root == null)
            return 0;
        
        this.out = 0;
        this.target = targetSum;
        
        recPathSum(root, 0, new HashMap<Integer, Integer>());
        
        return this.out;
        
    }
    
    private void recPathSum(TreeNode curr, int sum, Map<Integer, Integer> map) {
        sum += curr.val;
        
        int gap = sum - this.target;
        if (gap == 0) {
            this.out++;
        }
        
        this.out += map.getOrDefault(gap, 0);
        
        map.put(sum, map.getOrDefault(sum, 0) + 1);
            
        
        if (curr.left != null)
            recPathSum(curr.left, sum, map);
        
        if (curr.right != null)
            recPathSum(curr.right, sum, map);
        
        map.put(sum, map.get(sum) - 1);
    }
}