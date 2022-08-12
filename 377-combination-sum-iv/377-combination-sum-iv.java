class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] val = new int[target + 1];
        val[0] = 1;
        
        for (int t = 1; t <= target; t++) {
            int v = 0;
            for (int num : nums) {
                if (num <= t)
                    v += val[t - num];
                val[t] = v;
            }
        }
        
        return val[target];
    }

}