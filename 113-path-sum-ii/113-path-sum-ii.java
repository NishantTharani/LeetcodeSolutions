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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> out = new ArrayList<>();
        
        if (root == null)
            return out;
        
        List<Integer> curr = new ArrayList<>();
        curr.add(root.val);
        
        recPathSum(root, curr, targetSum, 0, out);
        
        return out;
    }
    
    private void recPathSum(TreeNode currNode, List<Integer> currList, int target, int currSum, List<List<Integer>> outList) {
        if (currNode.left == null && currNode.right == null && currSum + currNode.val == target) {
            List<Integer> currCopy = new ArrayList<>(currList);
            outList.add(currCopy);
        }
        
        if (currNode.left != null) {
            currList.add(currNode.left.val);
            recPathSum(currNode.left, currList, target, currSum + currNode.val, outList);
            currList.remove(currList.size() - 1);
        }
        
        if (currNode.right != null) {
            currList.add(currNode.right.val);
            recPathSum(currNode.right, currList, target, currSum + currNode.val, outList);
            currList.remove(currList.size() - 1);
        }
    }
    
    
}