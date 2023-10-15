class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        out = -float('inf')
        start = 0
        current_sum = 0

        for end in range(len(nums)):
            # Add nums[end] to the sliding window
            current_sum += nums[end]

            # Move up the start of the sliding window
            while start < end and nums[start] < 0:
                current_sum -= nums[start]
                start += 1
            
            # If nums[end] alone would be better, move up start some more
            if nums[end] > current_sum:
                start = end
                current_sum = nums[end]
            
            out = max(out, current_sum)
        
        return out