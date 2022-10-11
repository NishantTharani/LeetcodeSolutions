class Solution:
    def minSteps(self, s: str, t: str) -> int:
        s_count = [0 for _ in range(26)]
        t_count = [0 for _ in range(26)]
        
        for c in s:
            s_count[ord(c) - 97] += 1
        
        for c in t:
            t_count[ord(c) - 97] += 1
        
        under_count = 0
        over_count = 0
        for sc, tc in zip(s_count, t_count):
            if tc < sc:
                under_count += (sc - tc)
            elif sc < tc:
                over_count += (tc - sc)
        
        out = min(under_count, over_count)
        under_count -= out
        over_count -= out
        out += max(under_count, over_count)
        
        return out
        
"""
Brainstorm:
frequency maps
and then count the abs() of differences?

if they're lower case letters then I don't need freq maps: just arr[26]s
"""