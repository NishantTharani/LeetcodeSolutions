class Solution:
    def maxResult(self, nums: List[int], k: int) -> int:
        n = len(nums);
        val = [nums[0]]
        heap = []
        heapq.heappush(heap, -val[0])
        freq = collections.defaultdict(int)
        freq[-val[0]] += 1
        
        for i in range(1, n):
            if i - k - 1 >= 0:
                freq[-val[i-k-1]] -= 1
            while freq[heap[0]] == 0:
                heapq.heappop(heap)
            val.append(-heap[0] + nums[i])
            heapq.heappush(heap, -val[i])
            freq[-val[-1]] += 1

        return val[n-1]

