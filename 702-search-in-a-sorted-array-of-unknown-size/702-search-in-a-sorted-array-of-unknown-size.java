/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        if (reader.get(0) == target)
            return 0;
        
        int left = 0;
        int right = 1;
        
        while (reader.get(right) < target)
            right *= 2;
        
        // Regular binary search from here
        int mid;
        while (left <= right) {
            mid = left + (right - left)/2;
            if (reader.get(mid) == target) {
                return mid;
            } else if (target < reader.get(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return -1;
    }
}