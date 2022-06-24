class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0)
            return 1;
        
        if (n == 1)
            return 0;
        
        
        int toXor = 1;
        
        while (toXor <= n)
            toXor *= 2;
        
        toXor--;
        return toXor ^ n;
    }
}