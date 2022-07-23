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
    public int maxDepth(TreeNode root) {
        int out = 0;
        if (root == null)
            return out;
        
        Stack<Pair<TreeNode,Integer>> stack = new Stack<>();
        stack.push(new Pair<TreeNode,Integer>(root,1));
        
        while (!stack.isEmpty()) {
            Pair<TreeNode,Integer> curr = stack.pop();
            out = Math.max(out, curr.getValue());
            if (curr.getKey().left != null)
                stack.push(new Pair<TreeNode,Integer>(curr.getKey().left, curr.getValue()+1));
            if (curr.getKey().right != null)
                stack.push(new Pair<TreeNode,Integer>(curr.getKey().right, curr.getValue()+1));
        }
        
        return out;
    }
}