# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        stack = []
        stack.append(root)
        
        while len(stack) > 0:
            curr = stack.pop()
            if self.trees_are_equal(curr, subRoot):
                return True
            if curr is not None:
                stack.append(curr.left)
                stack.append(curr.right)
        
        return False
    
    def trees_are_equal(self, curr, other):
        if curr is None and other is None:
            return True
        
        if curr is None or other is None:
            return False
        
        if curr.val != other.val:
            return False
        
        return True and self.trees_are_equal(curr.left, other.left) and self.trees_are_equal(curr.right, other.right)