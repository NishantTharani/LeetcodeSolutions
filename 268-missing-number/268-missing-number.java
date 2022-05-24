class Solution {
    public int missingNumber(int[] nums) {
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i && nums[i] != -1) {
                if (nums[i] == nums.length) {
                    nums[i] = -1;
                } else {
                    tmp = nums[i];
                    nums[i] = nums[tmp];
                    nums[tmp] = tmp;
                }
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1)
                return i;
        }
        
        return nums.length;
    }
}