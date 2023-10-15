class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        freq = {
            0: 0,
            1: 0,
            2: 0
        }

        for num in nums:
            freq[num] += 1
        
        for idx in range(freq[0]):
            nums[idx] = 0
        
        for idx in range(freq[0], freq[0] + freq[1]):
            nums[idx] = 1
        
        for idx in range(freq[0] + freq[1], freq[0] + freq[1] + freq[2]):
            nums[idx] = 2
        