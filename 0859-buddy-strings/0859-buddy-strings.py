class Solution:
    def buddyStrings(self, s: str, goal: str) -> bool:
        swapped_chars = False
        swap_at = None
        can_swap = False
        chars_seen = set()
        
        if len(s) != len(goal):
            return False
        
        for i in range(len(s)):
            if s[i] in chars_seen:
                can_swap = True
            else:
                chars_seen.add(s[i])
            
            if s[i] == goal[i]:
                continue
                
            if swapped_chars:
                return False
            
            if swap_at is None:
                swap_at = i
            else:
                if s[swap_at] != goal[i] or s[i] != goal[swap_at]:
                    return False
                swapped_chars = True
                swap_at = None
        
        if swap_at is not None:
            return False
        
        return swapped_chars or can_swap

"""
Could try swapping all combinations of 2 letters and testing equality: O(n^2) time
Frequency mapping is not enough because order matters
Iterate over both strings. Store something as soon as I find one char that doesn't match. If I find another char that doesn't match, return false if they can't be swapped. And even if they can, return false if I find another non-match later on

abcd
dbca
"""