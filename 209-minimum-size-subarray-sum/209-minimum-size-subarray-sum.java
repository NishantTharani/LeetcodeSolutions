class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum;
        int start;
        
        for (int len = 1; len <= nums.length; len++) {
            // Sliding window for all subarrays that are 'len' long
            sum = 0;
            start = 0;
            
            for (int i = 0; i < nums.length; i++) {
                if (i < len) {
                    sum += nums[i];
                } else {
                    // We now have a valid window
                    if (sum >= target) {
                        return len;
                    }
                    sum -= nums[start];
                    start++;
                    sum += nums[i];
                }
            }
            
            if (sum >= target) {
                return len;
            }
            
        }
        
        return 0;
    }
}