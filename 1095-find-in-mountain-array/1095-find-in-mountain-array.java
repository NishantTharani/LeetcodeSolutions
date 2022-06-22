/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 0;
        int right = mountainArr.length() - 1;
        int curr;
        int next;
        int mid;
        int peak;
        
        // Find the peak
        while (left < right) {
            mid = left + (right - left)/2;
            curr = mountainArr.get(mid);
            next = mountainArr.get(mid+1);
            
            if (curr > next) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        
        // The peak is now left/right (both are the same)
        peak = left;
        
        // Search for the target between 0 and peak, if found return it
        left = 0;
        
        while (left <= right) {
            mid = left + (right - left)/2;
            curr = mountainArr.get(mid);
            
            if (curr == target) {
                return mid;
            } else if (target < curr) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        // Now search for target between peak and the end of the array
        left = peak;
        right = mountainArr.length() - 1;
        
        while (left <= right) {
            mid = left + (right - left)/2;
            curr = mountainArr.get(mid);
            
            if (curr == target) {
                return mid;
            } else if (target > curr) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return -1;
        
    }
}