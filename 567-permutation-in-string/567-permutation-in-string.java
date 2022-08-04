class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length())
            return false;
        
        int[] freq = new int[26];
        int[] match = new int[26];
        
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i)-97]++;
        }
        
        int start = 0;
        
        for (int end = 0; end < s2.length(); end++) {
            char c = s2.charAt(end);
            match[c-97]++;
            
            while (match[c-97] > freq[c-97]) {
                match[s2.charAt(start)-97]--;
                start++;
            }
            
            if (end - start + 1 == s1.length())
                return true;
        }
        
        return false;
        
        
    }
}