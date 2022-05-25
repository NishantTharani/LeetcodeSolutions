class Solution {
    public int findKthPositive(int[] arr, int k) {
        int out = 1;
        int i = 0;
        k--;
        
        while (i < arr.length) {
            if (out == arr[i]) {
                i++;
                out++;
            } else if (k == 0) {
                return out;
            } else {
                out++;
                k--;
            }
        }
        
        while (k > 0) {
            out++;
            k--;
        }
        
        return out;
        
        
    }
}