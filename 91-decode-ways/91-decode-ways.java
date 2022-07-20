class Solution {
    public int numDecodings(String s) {
        int[] val = new int[s.length() + 1];
        val[s.length()] = 1;
        
        // The value of val[i] is the number of ways to decode the substring from index i to the end
        
        for (int start = s.length() - 1; start >= 0; start--) {
            int v = 0;
            
            // First check if the character at start is a valid letter by itself
            if (s.charAt(start) != '0')
                v += val[start+1];
            
            // Then check if the character at start and the next one are a valid 2 digit number
            if (start < s.length() - 1 && (s.charAt(start) == '1' || (s.charAt(start) == '2' && Character.getNumericValue(s.charAt(start+1)) < 7)))
                v += val[start+2];
            
            val[start] = v;
        }
        
        return val[0];
    }
}