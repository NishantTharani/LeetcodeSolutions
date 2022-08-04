class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        
        for (int len = 1; len < s.length(); len++) {
            for (int i = 0; i < s.length() - len; i++) {
                if (isPalindrome(s, i, i+len)) {
                    start = i;
                    end = i + len;
                    break;
                }
            }
        }
        
        return s.substring(start, end+1);
        
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        while (end > start) {
            if (s.charAt(end) != s.charAt(start))
                return false;
            start++;
            end--;
        }
        
        return true;
    }
}