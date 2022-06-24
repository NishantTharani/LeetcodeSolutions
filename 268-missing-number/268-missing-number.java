class Solution {
    public int missingNumber(int[] nums) {
        int totalRemainder = 0;
        int arrayRemainder = 0;
        int n = nums.length + 1;
        
        for (int i = 0; i < n; i++) {
            totalRemainder += i;
            totalRemainder %= n;
        }
        
        for (int i = 0; i < nums.length; i++) {
            arrayRemainder += nums[i];
            arrayRemainder %= n;
        }
        
        int out = totalRemainder - arrayRemainder;
        if (out < 0)
            out += n;
        
        return out;
    }
}