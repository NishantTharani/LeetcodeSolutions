class Solution {
    public int maxProfit(int[] prices) {
        int out = 0;
        int min = prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            out = Math.max(out, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        
        return out;
    }
}