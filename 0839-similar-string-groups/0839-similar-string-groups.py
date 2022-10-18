class Solution:
    def numSimilarGroups(self, strs: List[str]) -> int:
        sets = [-1 for _ in range(len(strs))]
        
        for i1, s1 in enumerate(strs):
            for i2 in range(i1+1,len(strs)):
                s2 = strs[i2]
                if self.check_similar(s1, s2):
                    print("Unifying: " + str(i1) + " and " + str(i2))
                    # Unify the two sets at index i1 and i2 if they are different
                    p1 = i1
                    while sets[p1] != -1:
                        p1 = sets[p1]
                    p2 = i2
                    while sets[p2] != -1:
                        p2 = sets[p2]
                    if p1 != p2:
                        sets[p1] = p2

        
        count = 0
        for i in sets:
            if i == -1:
                count += 1
        return count
        
    
    def check_similar(self, s1, s2):
        # Check if s1 and s2 are similar in one pass
        swapped = False
        can_swap = True
        c1 = None
        c2 = None
        for i, j in zip(s1, s2):
            if i != j:
                if swapped:
                    if i == c2 and j == c1 and can_swap:
                        can_swap = False
                        continue
                    else:
                        return False
                else:
                    c1 = i
                    c2 = j
                    swapped = True
        
        if swapped and can_swap:
            return False
        
        return True