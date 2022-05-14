class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int out = 0;
        
        for (int i = 0; i < nums.length - 2; i++) {
            int max = target - nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            
            while (j < k) {
                if (nums[j] + nums[k] < max) {
                    out += k - j;
                    j++;
                } else {
                    k--;
                }
            }
        }
        
        return out;
    }
}