# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        # max_sum = float('-inf')
        
        def rec(root, curr_sum):
            # nonlocal max_sum
            
            # Base case: node is None
            if root is None:
                return (0, curr_sum)
            
            # Recurse left and right to get the max downward path starting from that node
            go_left, curr_sum = rec(root.left, curr_sum)
            go_right, curr_sum = rec(root.right, curr_sum)
            
            # Get max path sum going through root and update max_sum
            sum_through_root = root.val + go_left + go_right
            next_curr_sum = max(sum_through_root, curr_sum)
            
            # Return max downward path starting from this node
            return (max(max(go_left, go_right) + root.val, 0), next_curr_sum)
        
        _, out = rec(root, float('-inf'))
        return out

