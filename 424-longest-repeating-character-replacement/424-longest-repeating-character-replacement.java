class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int mostSeen = 0;
        int max = 0;
        int start = 0;
        Character endChar;
        Character startChar;
        
        for (int end = 0; end < s.length(); end++) {
            endChar = s.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);
            mostSeen = Math.max(mostSeen, map.get(endChar));
            
            while (end + 1 - start - mostSeen > k) {
                // Adjust start
                startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                start++;
            }
            
            max = Math.max(max, end + 1 - start);
        }
        
        return max;
    }
}