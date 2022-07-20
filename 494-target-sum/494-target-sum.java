class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int[][] val = new int[2001][n+1];
        
        // val[i][j] is the number of ways to make the sum of i using the first j values of nums
        
        for (int i = 0; i <= 2000; i++)
            val[i][0] = 0;
        val[1000][0] = 1;
        
        for (int j = 1; j <= nums.length; j++) {
            for (int i = 0; i <= 2000; i++) {
                int num = nums[j-1];
                int v = 0;
                
                if (i-num >= 0)
                    v += val[i-num][j-1];
                
                if (i+num <= 2000)
                    v += val[i+num][j-1];
                
                val[i][j] = v;
            }
        }
        
        return val[target+1000][n];
    }
}