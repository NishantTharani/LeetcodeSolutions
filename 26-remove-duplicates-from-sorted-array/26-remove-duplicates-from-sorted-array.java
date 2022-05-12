class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1)
            return 1;
        
        int k = 1;
        int i = 1;
        int end = nums.length;
        
        while (i < end) {
            if (nums[i] > nums[i-1]) {
                k++;
                i++;
            } else if (nums[i] == nums[i-1]) {
                int j = i;
                while (j < nums.length - 1 && nums[j] <= nums[j+1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                    j++;
                }
                end--;
            }
        }
        return k;
    }
}