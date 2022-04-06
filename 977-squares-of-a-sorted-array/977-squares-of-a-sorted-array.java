class Solution {
    public int[] sortedSquares(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int curr = end;
        int[] out = new int[end+1];
        
        while (start <= end) {
            if (Math.abs(nums[start]) >= Math.abs(nums[end])) {
                out[curr] = nums[start] * nums[start];
                start++;
            } else {
                out[curr] = nums[end] * nums[end];
                end--;
            }
            curr--;
        }
        
        return out;
    }
}