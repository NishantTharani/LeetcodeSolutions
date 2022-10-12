class Solution:
    def maxProfitAssignment(self, difficulty: List[int], profit: List[int], worker: List[int]) -> int:
        jobs = [(d, p) for d, p in zip(difficulty, profit)]
        jobs.sort(key = lambda job : job[0])  # ascending order of difficulty
        worker.sort()
        max_so_far = 0
        job_idx = 0
        worker_idx = 0
        out = 0
                
        while worker_idx < len(worker) and worker[worker_idx] < jobs[0][0]:
            worker_idx += 1
        
        while worker_idx < len(worker):
            while job_idx < len(jobs) and worker[worker_idx] >= jobs[job_idx][0]:
                max_so_far = max(max_so_far, jobs[job_idx][1])
                job_idx += 1
            
            out += max_so_far
            worker_idx += 1
        
                
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