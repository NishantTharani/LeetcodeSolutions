class Solution:
    def maxResult(self, nums: List[int], k: int) -> int:
        n = len(nums);
        val = [nums[0]]
        deque = collections.deque()
        deque.append(0)
        
        for i in range(1, n):
            while len(deque) > 0 and deque[0] < i-k:
                deque.popleft()
            val.append(nums[i] + val[deque[0]])
            while len(deque) > 0 and val[i] > val[deque[-1]]:
                deque.pop()
            deque.append(i)

        return val[n-1]

