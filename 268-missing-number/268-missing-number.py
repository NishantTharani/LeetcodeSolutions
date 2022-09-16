class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        n = len(nums)
        
        for i in range(n):
            while nums[i] != i and nums[i] != n:
                tmp = nums[nums[i]]
                nums[nums[i]] = nums[i]
                nums[i] = tmp
        
        for idx, val in enumerate(nums):
            if val != idx:
                return idx
        
        return n
        