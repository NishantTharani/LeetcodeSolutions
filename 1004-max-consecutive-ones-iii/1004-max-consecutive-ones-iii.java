class Solution {
    public int longestOnes(int[] nums, int k) {
        int ones = 0;
        int start = 0;
        int max = 0;
        
        for (int end = 0; end < nums.length; end++) {
            ones += nums[end];
            
            while (end + 1 - start - ones > k) {
                ones -= nums[start];
                start++;
            }
            
            max = Math.max(max, end + 1 - start);
        }
        
        return max;
    }
}