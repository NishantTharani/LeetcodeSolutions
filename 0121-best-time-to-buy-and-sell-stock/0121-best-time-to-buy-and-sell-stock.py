class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        out = 0
        best_selling_price = prices[-1]
        for price in prices[::-1]:
            best_selling_price = max(best_selling_price, price)
            out = max(out, best_selling_price - price)
        
        return out