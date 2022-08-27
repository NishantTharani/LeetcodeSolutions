class Solution:
    def minKBitFlips(self, nums: List[int], k: int) -> int:
        flips = 0
        flipped = False
        flip_points = collections.deque()
        
        for i in range(len(nums) - k + 1):
            if len(flip_points) > 0 and flip_points[0] == i:
                flipped = not flipped;
                flip_points.popleft();
                
            zero = 0 if not flipped else 1
            
            if nums[i] == zero:
                flips += 1
                flipped = not flipped
                flip_points.append(i + k)
        
        for i in range(len(nums) - k + 1, len(nums)):
            if len(flip_points) > 0 and flip_points[0] == i:
                flipped = not flipped;
                flip_points.popleft();
                
            zero = 0 if not flipped else 1
            
            if nums[i] == zero:
                return -1
        
        return flips