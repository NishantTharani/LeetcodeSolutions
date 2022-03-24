class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // Build a frequency map of p's letters
        int[] map = new int[26];
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            map[c - 'a']++;
        }
        List<Integer> out = new LinkedList<Integer>();
        
        // Slide a window over string 's' looking for valid anagrams
        int pLength = p.length();
        int[] smap = new int[26];
        int start = 0;
        char endChar;
        char startChar;
        for (int end = 0; end < s.length(); end++) {
            endChar = s.charAt(end);
            smap[endChar - 'a']++;
            
            while (smap[endChar - 'a'] > map[endChar - 'a']) {
                startChar = s.charAt(start);
                smap[startChar - 'a']--;
                start++;
            }
            
            if (end + 1 - start == pLength)
                out.add(start);
            
        }
        
        return out;
    }
}