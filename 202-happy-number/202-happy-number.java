class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        
        do {
            slow = sumSquareDigits(slow);
            fast = sumSquareDigits(fast);
            fast = sumSquareDigits(fast);
        } while (slow != fast);
        
        if (slow == 1) {
            return true;
        } else {
            return false;
        }
        
    }
    
    private int sumSquareDigits(int n) {
        int out = 0;
        
        while (n > 0) {
            out += (n % 10) * (n % 10);
            n /= 10;
        }
        
        return out;
    }
}