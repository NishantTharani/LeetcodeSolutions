class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int out = 0;
        int prod = 1;
        int start = 0;
        
        for (int end = 0; end < nums.length; end++) {
            prod *= nums[end];
            
            while (prod >= k && start <= end) {
                prod /= nums[start];
                start++;
            }
            
            out += end + 1 - start;
        }
        
        return out;
    }
}