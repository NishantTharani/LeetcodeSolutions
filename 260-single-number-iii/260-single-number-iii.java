class Solution {
    public int[] singleNumber(int[] nums) {
        int xorOfBoth = 0;
        
        for (int num : nums)
            xorOfBoth ^= num;
        
        int rightMostBit = 1;
        
        while ((rightMostBit & xorOfBoth) == 0)
            rightMostBit = rightMostBit << 1;
        
        int num1 = 0;
        int num2 = 0;
        
        for (int num : nums) {
            if ((num & rightMostBit) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        
        return new int[]{num1, num2};
    }
}