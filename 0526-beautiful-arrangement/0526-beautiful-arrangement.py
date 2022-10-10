class Solution:
    def countArrangement(self, n: int) -> int:
        # Define which numbers can go at which index
        allowed = collections.defaultdict(list)
        for i in range(1, n+1):
            for j in range(1, n+1):
                if i % j == 0 or j % i == 0:
                    allowed[i].append(j)
        
        return self.rec(n, allowed, set(), 1)
    
    def rec(self, n, allowed, curr_set, curr_idx):
        if curr_idx > n:
            return 1
        
        out = 0
        for candidate in allowed[curr_idx]:
            if candidate not in curr_set:
                curr_set.add(candidate)
                out += self.rec(n, allowed, curr_set, curr_idx+1)
                curr_set.remove(candidate)
        
        return out
        
