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
    
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        
        this.out = 0;
        
        recDiameter(root, new HashMap<TreeNode, Integer>(), new ArrayList<TreeNode>());
        
        return this.out;
    }
    
    private int recDiameter(TreeNode curr, Map<TreeNode, Integer> map, List<TreeNode> path) {
        if (curr.left == null && curr.right == null) {
            for (int i = 0; i < path.size(); i++) {
                this.out = Math.max(this.out, path.size() - i + map.getOrDefault(path.get(i), 0));
            }
            
            return 1;
        }
        
        int left = 0;
        int right = 0;
        path.add(curr);
        
        if (curr.left != null)
            left = recDiameter(curr.left, map, path);
        
        map.put(curr, Math.max(map.getOrDefault(curr, 0), left));
        
        if (curr.right != null)
            right = recDiameter(curr.right, map, path);
        
        map.put(curr, Math.max(map.getOrDefault(curr, 0), right));
        
        path.remove(path.size() - 1);
        
        return Math.max(left, right) + 1;
    }
}