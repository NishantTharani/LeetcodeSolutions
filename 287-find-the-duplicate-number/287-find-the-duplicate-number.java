class Solution {
    public int findDuplicate(int[] nums) {
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i+1) {
                tmp = nums[i];
                if (tmp == nums[tmp-1])
                    return tmp;
                nums[i] = nums[tmp-1];
                nums[tmp-1] = tmp;
            }
        }
        
        return -1;
    }
}