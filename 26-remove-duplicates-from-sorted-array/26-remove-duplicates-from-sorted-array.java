class Solution {
    public int removeDuplicates(int[] nums) {
        int start = 1;
        
        for (int curr = 1; curr < nums.length; curr++) {
            if (nums[curr] != nums[curr-1]) {
                nums[start] = nums[curr];
                start++;
            }
        }
        
        return start;
    }
}