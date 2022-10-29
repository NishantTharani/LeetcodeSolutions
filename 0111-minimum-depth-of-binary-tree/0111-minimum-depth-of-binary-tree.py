# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        def rec(curr, count):
            if curr.left is None and curr.right is None:
                return count+1
            
            out = float('inf')
            if curr.left is not None:
                out = min(out, rec(curr.left, count+1))
            
            if curr.right is not None:
                out = min(out, rec(curr.right, count+1))
            
            return out
                    
        if root is None:
            return 0
        
        return rec(root, 0)