class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        out = -float('inf')
        current_sum = 0
        
        for num in nums:
            current_sum = max(num, current_sum + num)
            out = max(out, current_sum)
        
        return out