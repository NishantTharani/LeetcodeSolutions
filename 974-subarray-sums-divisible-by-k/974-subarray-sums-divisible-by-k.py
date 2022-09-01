class Solution:
    def subarraysDivByK(self, nums: List[int], k: int) -> int:
        count = 0
        remainders = collections.defaultdict(int)
        
        total = 0
        for num in nums:
            total += num
            remainder = total % k
            if remainder == 0:
                count += 1 + remainders[remainder]
            else:
                count += remainders[remainder]
            remainders[remainder] += 1
            
        return count