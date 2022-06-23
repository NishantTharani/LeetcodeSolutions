class Solution {
    public int search(int[] nums, int target) {
        // Find the start and end of the subarray within which to binary search
        boolean pivoted = nums[0] > nums[nums.length - 1];
        int left = 0;
        int right = nums.length - 1;
        int mid;
        int pivot = -1;
        
        // If pivoted, find the pivot element's index then set left and right appropriately
        if (pivoted) {
            // pivot will be the first element that's less than its predecessor
            while (pivot == -1) {
                mid = left + (right - left + 1)/2;
                
                if (nums[mid] < nums[mid-1]) {
                    pivot = mid;
                } else if (nums[mid] < nums[0]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }    
            }
            
            if (target >= nums[0]) {
                left = 0;
                right = pivot - 1;
            } else {
                left = pivot;
                right = nums.length - 1;
            }
        }
        
        // Finally, run normal binary search between left and right
        mid = -1;
        while (left <= right) {
            mid = left + (right - left)/2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return -1;
        
    }
}
