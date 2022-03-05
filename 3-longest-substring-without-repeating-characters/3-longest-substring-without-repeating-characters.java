class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        Character endChar, startChar;
        
        for (int end = 0; end < s.length(); end++) {
            endChar = s.charAt(end);
            
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);
            
            while (map.get(endChar) > 1) {
                startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                start++;
            }
            
            max = Math.max(max, end + 1 - start);
        }
        
        return max;
    }
}