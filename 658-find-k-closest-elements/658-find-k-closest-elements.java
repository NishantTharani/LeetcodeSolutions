class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Binary search to find the location of the closest number to x
        
        int left = 0;
        int right = arr.length - 1;
        
        while (left != right) {
            int mid = (left + right + 1)/2;
            
            if (x == arr[mid]) {
                left = mid;
                right = mid;
            } else if (x < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        
        if (left < arr.length - 1 && Math.abs(arr[left] - x) > Math.abs(arr[left+1] - x)) {
            left++;
            right++;
        }
        
        // Now arr[left] is the closest element to x
        while (right - left + 1 < k) {
            if (left == 0) {
                right++;
            } else if (right == arr.length - 1) {
                left--;
            } else if (Math.abs(x - arr[left-1]) <= Math.abs(x - arr[right+1])) {
                left--;
            } else {
                right++;
            }
        }
        
        List<Integer> out = new ArrayList<>();
        for (int i = left; i <= right; i++)
            out.add(arr[i]);
        
        return out;
    }
}