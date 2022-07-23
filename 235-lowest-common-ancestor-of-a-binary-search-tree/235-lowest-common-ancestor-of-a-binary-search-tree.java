/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // DFS for each node and pick the last node that is in common?
        Queue<TreeNode> pPath = new LinkedList<>();
        TreeNode curr = root;
        pPath.add(curr);
        
        while (curr != p) {
            if (p.val < curr.val) {
                curr = curr.left;
            } else if (p.val > curr.val) {
                curr = curr.right;
            }
            pPath.add(curr);
        }
        
        Queue<TreeNode> qPath = new LinkedList<>();
        curr = root;
        qPath.add(curr);
        while (curr != q) {
            if (q.val < curr.val) {
                curr = curr.left;
            } else if (q.val > curr.val) {
                curr = curr.right;
            }
            qPath.add(curr);
        }
        
        curr = root;
        while (pPath.peek() == qPath.peek()) {
            curr = pPath.poll();
            qPath.poll();
        }
        
        return curr;
    }
}