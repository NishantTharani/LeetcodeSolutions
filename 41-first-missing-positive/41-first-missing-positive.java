class Solution {
    public int firstMissingPositive(int[] nums) {
        int tmp;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            while (nums[i] != i+1 && nums[i] != -1) {
                tmp = nums[i];
                if (tmp >= 1 && tmp <= n && nums[tmp-1] != tmp) {
                    nums[i] = nums[tmp-1];
                    nums[tmp-1] = tmp;
                } else {
                    nums[i] = -1;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (nums[i] < 1) 
                return i+1;
        }
        
        return n+1;
    }
}