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
    class NodeVal {
        TreeNode node;
        int val;
        
        NodeVal(TreeNode node, int val) {
            this.val = val;
            this.node = node;
        }
    }
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        
        Deque<NodeVal> stack = new LinkedList<>();
        stack.add(new NodeVal(root, root.val));
        NodeVal tmp;
        TreeNode curr;
        
        while (stack.size() > 0) {
            tmp = stack.removeFirst();
            curr = tmp.node;
            
            if (curr.left != null)
                stack.addFirst(new NodeVal(curr.left, tmp.val + curr.left.val));
            
            if (curr.right != null)
                stack.addFirst(new NodeVal(curr.right, tmp.val + curr.right.val));
            
            if (curr.right == null && curr.left == null && tmp.val == targetSum)
                return true;
        }
        
        return false;
        
        
        
        
    }
    
}