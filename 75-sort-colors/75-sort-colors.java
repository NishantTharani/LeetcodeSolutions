class Solution {
    public void sortColors(int[] nums) {
        // First put all the 2's at the back
        int end = nums.length - 1;
        
        for (int start = 0; start < end; start++) {
            while (end > 0 && nums[end] == 2) {
                end--;
            }
            
            if (nums[start] == 2 && start < end) {
                int tmp = nums[end];
                nums[end] = nums[start];
                nums[start] = tmp;
                end--;
            }
        }
        
        // Find the location of the last 0 or 1
        while (end > 0 && nums[end] == 2) {
                end--;
        }
        
        // Now put all the 1s at the back
        for (int start = 0; start < end; start++) {
            while (end > 0 && nums[end] == 1) {
                end--;
            }
            
            if (nums[start] == 1 && start < end) {
                int tmp = nums[end];
                nums[end] = nums[start];
                nums[start] = tmp;
                end--;
            }
        }
    }
}