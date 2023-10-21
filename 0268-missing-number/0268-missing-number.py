class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        total = 0
        for i in range(len(nums)):
            total += i
            total -= nums[i]
        total += len(nums)
        return total