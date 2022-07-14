class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int k = nums.length;
        int sum = 1000;
        
        int[][] val = new int[2*sum + 1][k+1];
        
        for (int i = 0; i <= 2*sum; i++)
            val[i][0] = 0;
        val[sum][0] = 1;
        
        for (int j = 1; j <= k; j++) {
            for (int i = 0; i <= 2*sum; i++) {
                int num = nums[j-1];
                int v = 0;
                if (i - num >= 0)
                    v += val[i - num][j-1];
                if (i + num <= 2*sum)
                    v += val[i + num][j-1];
                val[i][j] = v;
            }
        }
        
        return val[target+sum][k];
    }
}