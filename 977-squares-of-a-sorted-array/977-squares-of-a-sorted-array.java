class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] out = new int[n];
        int start = 0;
        int end = n-1;
        int i = n-1;
        
        while (start <= end) {
            if (Math.abs(nums[end]) > Math.abs(nums[start])) {
                out[i] = nums[end] * nums[end];
                i--;
                end--;
            } else {
                out[i] = nums[start] * nums[start];
                i--;
                start++;
            }
        }
        
        return out;
    }
}