class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int[][] val = new int[m + 1][amount + 1];
        
        for (int j = 0; j <= amount; j++)
            val[0][j] = -1;
        
        for (int i = 0; i <= m; i++)
            val[i][0] = 0;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= amount; j++) {
                val[i][j] = -1;
            }
        }
                
        for (int i = 1; i <= m; i++) {
            int coin = coins[i-1];
            for (int j = 1; j <= amount; j++) {
                if (coin > j) {
                    val[i][j] = val[i-1][j];
                } else {
                    int dontUseCoin = val[i-1][j];
                    int useCoin = val[i][j-coin];
                    
                    if (dontUseCoin == -1 && useCoin == -1)
                        val[i][j] = -1;
                    else if (useCoin == -1)
                        val[i][j] = dontUseCoin;
                    else if (dontUseCoin == -1)
                        val[i][j] = useCoin + 1;
                    else
                        val[i][j] = Math.min(dontUseCoin, useCoin+1);
                }
            }
        }
        
        return val[m][amount];
    }
}