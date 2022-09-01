# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        count = 0
        stack = collections.deque()
        stack.append((root, root.val - 1))
        
        while len(stack) > 0:
            curr, val = stack.pop()
            if curr is not None:
                if curr.val >= val:
                    count += 1
                stack.append((curr.left, max(val, curr.val)))
                stack.append((curr.right, max(val, curr.val)))
            
        return count
    