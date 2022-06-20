class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }
    
    private int binarySearch(int[] nums, int target, int left, int right) {
        if (left == right) {
            if (nums[left] == target) {
                return left;
            } else {
                return -1;
            }
        }
        
        int middle = (left + right) / 2;
        
        if (target == nums[middle]) {
            return middle;
        } else if (target < nums[middle]) {
            return binarySearch(nums, target, left, middle);
        } else {
            return binarySearch(nums, target, middle+1, right);
        }
    }
}