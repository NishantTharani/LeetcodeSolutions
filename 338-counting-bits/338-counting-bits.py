class Solution:
    def countBits(self, n: int) -> List[int]:
        if n == 0:
            return [0]
        
        if n == 1:
            return [0, 1]
        
        out = [0, 1]
        start = 1
        curr = 1
        end = 1
        inc = False
        
        for i in range(2, n+1):
            out.append(out[curr] + int(inc))
            if curr == end:
                if not inc:
                    curr = start
                    inc = True
                else:
                    start = end + 1
                    end = len(out) - 1
                    curr = start
                    inc = False
            else:
                curr += 1
        
        return out
                    
            
         