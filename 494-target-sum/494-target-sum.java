class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int k = nums.length;
        
        int[][] val = new int[2001][k+1];
        
        for (int i = 0; i <= 2000; i++)
            val[i][0] = 0;
        val[1000][0] = 1;
        
        for (int j = 1; j <= k; j++) {
            for (int i = 0; i <= 2000; i++) {
                int num = nums[j-1];
                int v = 0;
                if (i - num >= 0)
                    v += val[i - num][j-1];
                if (i + num <= 2000)
                    v += val[i + num][j-1];
                val[i][j] = v;
            }
        }
        
        return val[target+1000][k];
    }
}