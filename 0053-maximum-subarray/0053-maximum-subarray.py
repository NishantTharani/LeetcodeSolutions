class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        curr = nums[0]
        out = nums[0]
        
        for num in nums[1:]:
            curr = max(num, curr+num)
            out = max(out, curr)
        
        return out