class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left)/2;
        int leftFinal;
        int rightFinal;
        
        // First find an index where the number is
        while (left <= right) {
            mid = left + (right - left)/2;
            if (nums[mid] == target) {
                break;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        if (left > right)
            return new int[]{-1, -1};
        
        // Now conduct two more binary searches to find the leftmost / rightmost appearance of target
        // Leftmost appearance will be in the range [0, mid]
        left = 0;
        right = mid;
        int leftMid;
        
        while (left != right) {
            leftMid = left + (right - left)/2;
            
            if (nums[leftMid] == target) {
                right = leftMid;
            } else {
                left = leftMid + 1;
            }
        }
        
        leftFinal = left;
        
        // Rightmost appearance will be in the range [mid, n-1]
        left = mid;
        right = nums.length - 1;
        int rightMid;
        
        while (left != right) {
            rightMid = left + (right - left + 1)/2;
            
            if (nums[rightMid] == target) {
                left = rightMid;
            } else {
                right = rightMid - 1;
            }
        }
        
        rightFinal = left;
        
        return new int[]{leftFinal, rightFinal};
    }
}