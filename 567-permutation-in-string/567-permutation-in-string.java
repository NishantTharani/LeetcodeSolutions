class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Create the char array of s1
        int[] s1chars = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1chars[s1.charAt(i) - 'a']++;
        }
        
        // Slide window
        int[] s2chars = new int[26];
        int count = 0;
        char s2char;
        int start = 0;
        for (int i = 0; i < s2.length(); i++) {
            s2char = s2.charAt(i);
            s2chars[s2char - 'a']++;
            count++;
            
            while (s2chars[s2char - 'a'] > s1chars[s2char - 'a']) {
                s2chars[s2.charAt(start) - 'a']--;
                count--;
                start++;
            }
            
            if (count == s1.length()) {
                return true;
            }
        }
        
        return false;
    }
}