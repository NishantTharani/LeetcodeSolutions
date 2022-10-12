class Solution:
    def maxProfitAssignment(self, difficulty: List[int], profit: List[int], worker: List[int]) -> int:
        jobs = [[d, p, 0] for d, p in zip(difficulty, profit)]
        jobs.sort(key = lambda job : job[0])  # ascending order of difficulty
        max_so_far = 0
        for job in jobs:
            max_so_far = max(max_so_far, job[1])
            job[2] = max_so_far
                
        # Each worker can binary search to find the toughest job they can complete
        out = 0
        for w in worker:
            # Binary search
            left = 0
            right = len(jobs) - 1
            mid = (left + right + 1) // 2
            while left != right:
                if jobs[mid][0] > w:
                    right = mid - 1
                else:
                    left = mid
                mid = (left + right + 1) // 2
            # Check feasibility in case mid = 0
            if jobs[mid][0] <= w:
                out += jobs[mid][2]
                
        return out

        
"""
Heuristic: each worker should complete the most profitable job that they can do?
How to efficiently code this

for each worker:
    set max_profit = 0
    for each job:
        if feasible and profit is higher than max profit: update max profit
O (M * N)

what if: sort jobs in order of difficulty, and then calculate the max profit for each level of difficulty? and then binary search for each worker?

O(NlogN + N + MlogN)


"""