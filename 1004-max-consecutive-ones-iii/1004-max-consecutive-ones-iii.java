class Solution {
    public int longestOnes(int[] nums, int k) {
        int flipped = 0;
        int start = 0;
        int max = 0;
        
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0)
                flipped++;
            
            while (flipped > k) {
                if (nums[start] == 0)
                    flipped--;
                start++;
            }
            
            max = Math.max(max, end + 1 - start);
        }
        
        return max;
    }
}