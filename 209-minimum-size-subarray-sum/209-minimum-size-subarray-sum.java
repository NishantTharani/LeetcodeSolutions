class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int out = Integer.MAX_VALUE;
        int start = 0;
        int sum = 0;
        
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= target) {
                out = Math.min(out, end + 1 - start);
                sum -= nums[start];
                start++;
            }
        }
        
        return out == Integer.MAX_VALUE ? 0 : out; 
    }
}