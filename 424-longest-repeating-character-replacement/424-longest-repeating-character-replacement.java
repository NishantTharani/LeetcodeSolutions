class Solution {
    public int characterReplacement(String s, int k) {
        int out = Integer.MIN_VALUE;
        
        for (int i = 'A'; i < 'A' + 26; i++) {
            char c = (char) i;
            int replaced = 0;
            int start = 0;
            boolean[] replacedAt = new boolean[s.length()];
            
            for (int end = 0; end < s.length(); end++) {
                if (s.charAt(end) != c) {
                    replaced++;
                    replacedAt[end] = true;
                }
                
                while (replaced > k) {
                    if (replacedAt[start])
                        replaced--;
                    start++;
                }
                
                out = Math.max(out, end - start + 1);
            }
        }
        
        return out;
    }
}