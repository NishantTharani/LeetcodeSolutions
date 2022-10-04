class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        out = []  # int array
        
        neg = False
        if (numerator < 0 and denominator > 0) or (numerator > 0 and denominator < 0):
            neg = True
        numerator = abs(numerator)
        denominator = abs(denominator)
        
        out.append(numerator // denominator)
        remainder = numerator % denominator
        
        if remainder == 0:
            out = [str(i) for i in out]
            if neg:
                out.insert(0, '-')
            return ''.join(out)
        
        # Now we need to do numerator/remainder where we know that numerator < remainder
        out.append('.')
        starts = {}  # maps (numerator, remainder) -> index of out
        
        while remainder > 0:
            remainder *= 10
            # If we've seen (numerator, remainder) before: then we know a pattern is about to repeat
            if (remainder, denominator) in starts:
                start_of_pattern = starts[(remainder, denominator)]
                out.insert(start_of_pattern, '(')
                out.append(')')
                break
            else:
                starts[(remainder, denominator)] = len(out)
            out.append(remainder // denominator)
            remainder = remainder % denominator
        
        # format and return
        out = [str(i) for i in out]
        if neg:
            out.insert(0, '-')
        return ''.join(out)
            
        

"""
7 / 6
1.1 
"""