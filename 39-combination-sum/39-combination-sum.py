class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        out = []
        self.rec(candidates, target, 0, out, [])
        return out
    
    def rec(self, candidates, remaining_target, candidate_idx, out, combination):
        # base case 1: we've reached target
        if remaining_target == 0:
            out.append(combination)
            return
        
        # base case 2: reached the end of candidates
        if candidate_idx == len(candidates):
            return
        
        if candidates[candidate_idx] <= remaining_target:
            next_combination = list(combination)
            next_combination.append(candidates[candidate_idx])
            self.rec(candidates, remaining_target - candidates[candidate_idx], candidate_idx, out, next_combination)
        
        self.rec(candidates, remaining_target, candidate_idx+1, out, combination)
        
        