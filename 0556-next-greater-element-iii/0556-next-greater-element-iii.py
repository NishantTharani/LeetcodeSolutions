class Solution:
    def nextGreaterElement(self, n: int) -> int:
        max_val = (2**31) - 1
        
        s = list(str(n));
        
        # Start at ones digit and work up
        for i in range(len(s) - 1, -1, -1):
            # Check subsequent digits for the largest so far that's still smaller than s[i]
            curr = int(s[i])
            largest_digit = 10
            largest_digit_at = -1
            for j in range(i+1, len(s)):
                if int(s[j]) > curr and int(s[j]) < largest_digit:
                    largest_digit = int(s[j])
                    largest_digit_at = j
            
            # If we've seen a larger digit, swap things around
            if largest_digit_at != -1:
                # Swap it with the larger digit
                tmp = s[largest_digit_at]
                s[largest_digit_at] = s[i]
                s[i] = tmp
                # Sort the subsequent digits
                tmp = s[i+1:]
                tmp.sort(key = lambda x : int(x))
                s[i+1:] = tmp
                out = int(''.join(s))
                if out <= max_val:
                    return out
                else:
                    return -1
       
        # If we found nothing
        return -1
                    