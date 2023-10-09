class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """

        if len(nums) == 1:
            return nums

        max_so_far = float('-inf')
        n = len(nums)

        for j in range(n-1, -1, -1):
            if nums[j] < max_so_far:
                # Find the smallest number after it that's larger
                idx_to_swap = None
                smallest_so_far = float('inf')
                for k in range(j+1, n):
                    if nums[k] > nums[j] and nums[k] < smallest_so_far:
                        smallest_so_far = nums[k]
                        idx_to_swap = k
                
                # Swap nums[j] with this number
                tmp = nums[j]
                nums[j] = nums[idx_to_swap]
                nums[idx_to_swap] = tmp
                
                # Sort nums[j+1:]
                nums[j+1:] = sorted(nums[j+1:])

                # Return nums
                return nums
            else:
                max_so_far = max(max_so_far, nums[j])
        
        nums.sort()



"""
What's the latest index in the array that we can swap an element out for a greater value in a later index?
    Has to be in a later index because we can't go from 1534 to 1354 but we can go to 1543
    To answer this: we can start from the back, and as soon as we find a value less than the max_so_far, we have our answer
    If we never do then we return the lowest possible order

Then, what's the smallest such greater value that we can swap it out for?
    That's all that matters, because what happens later on in is irrelevant
    But after swapping out for this smallest greater value, the remaining digits should be ordered in ascending order
    Also, to find this smallest greater value, we might want to keep the digits sorted anyway. So there's two reasons to keep them sorted
    AND to return the lowest possible order, we want them sorted

To keep them sorted we could use a maxheap:
    Go from back to front:
        If current is < top of maxheap:
            Swap current with top of maxheap
            Then replace the rest of the array with the maxheap in asc sorted order
        Else:
            Add current to max heap
    If we reach the front: replace the array with maxheap in asc sorted order

How to do this with constant sorted memory? Need to use the array itself as the maxheap?

Or is there some cleaner way, with constant time extra memory?
    Keep max_so_far
    Once we find something smaller, go from there to the end to find the smallest element greater than it
    Then swap them and sort the remaining subarray in place
"""
        