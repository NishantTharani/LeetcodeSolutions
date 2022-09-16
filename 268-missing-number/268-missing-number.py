class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        out = len(nums)
        
        for idx, val in enumerate(nums):
            out ^= idx
            out ^= val
        
        return out
        