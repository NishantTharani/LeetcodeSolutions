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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> out = new ArrayList<>();
        
        if (root == null)
            return out;
        
        Queue<TreeNode> queue = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        boolean reversed = false;
        int n;
        queue.add(root);
        TreeNode curr;
        
        while (queue.size() > 0) {
            List<Integer> tmp = new ArrayList<>();
            n = queue.size();
            
            for (int i = 0; i < n; i++) {
                curr = queue.poll();
                tmp.add(curr.val);
                if (reversed) {
                    if (curr.right != null)
                        queue.add(curr.right);
                    if (curr.left != null)
                        queue.add(curr.left);
                } else {
                    if (curr.left != null)
                        queue.add(curr.left);
                    if (curr.right != null)
                        queue.add(curr.right);
                }
            }
            
            out.add(tmp);
            
            // Reverse the queue
            while (queue.size() > 0) {
                stack.addFirst(queue.poll());
            }
            while (stack.size() > 0) {
                queue.add(stack.removeFirst());
            }
            reversed = !reversed;
        }
        
        return out;
    }
}