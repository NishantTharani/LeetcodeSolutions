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
    public boolean isValidBST(TreeNode root) {
        Stack<NodeCheck> stack = new Stack<>();
        NodeCheck first = new NodeCheck(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        stack.push(first);
        
        while (!stack.isEmpty()) {
            NodeCheck curr = stack.pop();
            if (curr.node.val < curr.min || curr.node.val > curr.max)
                return false;
            if (curr.node.left != null) {
                if (curr.node.val == Integer.MIN_VALUE)
                    return false;
                else
                    stack.push(new NodeCheck(curr.node.left, curr.min, Math.min(curr.max, curr.node.val - 1)));
            }
            if (curr.node.right != null) {
                if (curr.node.val == Integer.MAX_VALUE)
                    return false;
                else
                    stack.push(new NodeCheck(curr.node.right, Math.max(curr.min, curr.node.val + 1), curr.max));    
            }
        }
        
        return true;
    }
    
    class NodeCheck {
        TreeNode node;
        int min;
        int max;
        
        public NodeCheck(TreeNode node, int min, int max) {
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }
}