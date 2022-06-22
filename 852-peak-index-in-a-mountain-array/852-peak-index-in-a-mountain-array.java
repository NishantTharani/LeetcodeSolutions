class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        
        while (right - left > 2) {
            mid = left + (right - left)/2;
            
            if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
                return mid;
            } else if (arr[mid] > arr[mid-1] && arr[mid+1] > arr[mid]) {
                left = mid;
            } else {
                right = mid + 1;
            }
        }
        
        return (left+1);
    }
}