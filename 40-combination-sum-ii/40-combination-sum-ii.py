class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        out = []
        self.rec(candidates, 0, target, [], out)
        return out
    
    
    def rec(self, candidates, idx, target, curr, out):
        if target == 0:
            out.append(list(curr))
            return
        
        if idx >= len(candidates):
            return
        
        if target - candidates[idx] >= 0:
            curr.append(candidates[idx])
            self.rec(candidates, idx+1, target - candidates[idx], curr, out)
            curr.pop()
            
        next_idx = idx
        while next_idx < len(candidates) and candidates[next_idx] == candidates[idx]:
            next_idx += 1
        
        self.rec(candidates, next_idx, target, curr, out)
        
