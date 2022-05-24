class Solution {
    public int missingNumber(int[] nums) {
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i && nums[i] < nums.length) {
                tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i)
                return i;
        }
        
        return nums.length;
    }
}