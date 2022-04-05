class Solution {
    public String minWindow(String s, String t) {
        String out = "";
        Integer len = Integer.MAX_VALUE;
        int matches = 0;
        int start = 0;
        
        if (t.length() > s.length())
            return out;

        // Build frequency map of t
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            
            if (map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) - 1);
                if (map.get(endChar) == 0) {
                    matches++;
                }
            }
            
            while (matches == map.size()) {
                char startChar = s.charAt(start);
                if (map.containsKey(startChar)) {
                    if (map.get(startChar) == 0) {
                        if (end + 1 - start < len) {
                            len = end + 1 - start;
                            out = s.substring(start, end + 1);
                        }
                        matches--;
                    }
                    
                    map.put(startChar, map.get(startChar) + 1);
                }
                
                start++;
            }
        }
        return out;
    }
    
}