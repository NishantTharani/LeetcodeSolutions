class Solution:
    def generateAbbreviations(self, word: str) -> List[str]:
        # Enumeration pattern
        n = len(word)
        
        vals = [ [] for _ in range(n+2) ]
        
        vals[n+1].append('')
        vals[n].append('')
        vals[n-1].append('1')
        vals[n-1].append(word[n-1])
        
        for i in range(n-2, -1, -1):
            # How many characters to abbreviate?
            for j in range(n-i+1):
                start = ""
                if j > 0:
                    start += str(j)
                if i+j < n:
                    start += word[i+j]
                
                for end in vals[i+j+1]:
                    vals[i].append(start + end)
        
        return vals[0]
        
            