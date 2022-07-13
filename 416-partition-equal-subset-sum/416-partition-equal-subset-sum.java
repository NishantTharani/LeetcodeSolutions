class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        
        for (int num : nums)
            sum += num;
        
        if (sum % 2 == 1)
            return false;
        
        int target = sum / 2;
        int k = nums.length;
        
        boolean[][] val = new boolean[target+1][k+1];
        
        for (int i = 0; i <= target; i++)
            val[i][0] = false;
        
        for (int i = 0; i <= k; i++)
            val[0][i] = true;
        
        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= k; j++) {
                boolean ifLeave = val[i][j-1];
                boolean ifTake = i - nums[j-1] >= 0 && val[i - nums[j-1]][j-1];
                val[i][j] = ifLeave || ifTake;
            }
        }
        
        return val[target][k];
    }

}