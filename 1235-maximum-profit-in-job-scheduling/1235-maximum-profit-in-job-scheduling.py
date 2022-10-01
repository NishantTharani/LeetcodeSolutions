class Solution:
    def jobScheduling(self, startTime: List[int], endTime: List[int], profit: List[int]) -> int:
        profits_by_start = {}  # current idx -> max_profit
        jobs = list(zip(startTime, endTime, profit))
        jobs.sort(key=lambda job : job[0])
        return self.rec(jobs, 0, profits_by_start)
    
    def rec(self, jobs, current_idx, profits_by_start):
        key = current_idx
        if key in profits_by_start:
            return profits_by_start[key]
        
        if current_idx >= len(jobs):
            profits_by_start[key] = 0
            return 0
        
        next_idx = current_idx + 1
        while next_idx < len(jobs) and jobs[current_idx][1] > jobs[next_idx][0]:
            next_idx += 1
        
        # We can either pick the job at current_idx or not
        choose_job = jobs[current_idx][2] + self.rec(jobs, next_idx, profits_by_start)
        skip_job = self.rec(jobs, current_idx + 1, profits_by_start)
        
        profits_by_start[key] = max(choose_job, skip_job)
        return max(choose_job, skip_job)