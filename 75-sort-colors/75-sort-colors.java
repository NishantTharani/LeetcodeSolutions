class Solution {
    public void sortColors(int[] nums) {
        // First put all the 2's at the back
        int end = nums.length - 1;
        int start = 0;
        
        while (start < end) {
            if (nums[end] == 2) {
                end--;
            } else {
                if (nums[start] == 2) {
                    int tmp = nums[end];
                    nums[end] = nums[start];
                    nums[start] = tmp;
                    end--;
                }
                start++;
            }
        }
        
        // Find the location of the last 0 or 1
        while (end > 0 && nums[end] == 2) {
                end--;
        }
        
        start = 0;
        while (start < end) {
            if (nums[end] == 1) {
                end--;
            } else {
                if (nums[start] == 1) {
                    int tmp = nums[end];
                    nums[end] = nums[start];
                    nums[start] = tmp;
                    end--;
                }
                start++;
            }
        }
    }
}