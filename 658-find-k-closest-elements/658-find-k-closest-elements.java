class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int gap;
        int left = 0;
        int right = arr.length - 1;
        int mid;
        
        // First run binary search
        while (left <= right) {
            mid = left + (right - left)/2;
            
            if (arr[mid] == x) {
                left = mid;
                right = mid;
                break;
            } else if (x < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        // Now set left and right to be the bounds of the subarray that we will return
        if (right < 0) {
            right = left;
        } else if (left >= arr.length) {
            left = right;
        } else if (Math.abs(arr[right] - x) <= Math.abs(arr[left] - x)) {
            left = right;
        } else {
            right = left;
        }
        
        // Now expand the subarray until we've found enough elements
        while ((right - left + 1) < k) {
            if (left == 0) {
                right++;
            } else if (right == arr.length - 1) {
                left--;
            } else if (Math.abs(arr[left-1] - x) <= Math.abs(arr[right+1] - x)) {
                left--;
            } else {
                right++;
            }
        }
        
        // Copy the subarray
        List<Integer> out = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            out.add(arr[i]);
        }
        
        return out;
    }
}