# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        self.count = 0
        self.rec(root, root.val - 1)
        return self.count
        
    
    def rec(self, node, max_val):
        if node is not None:
            if node.val >= max_val:
                self.count += 1
        
            self.rec(node.left, max(max_val, node.val))
            self.rec(node.right, max(max_val, node.val))