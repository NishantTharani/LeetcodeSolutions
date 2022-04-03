class Solution {
    public String minWindow(String s, String t) {
        String out = "";
        Integer len = Integer.MAX_VALUE;
        
        if (t.length() > s.length())
            return out;
        
        // Build frequency map of t
        Map<Character, Integer> tmap = new HashMap<>();
        
        for (char c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }
        
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        
        for (int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);
            
            while (hasAllChars(map, tmap)) {
                if (end - start + 1 < len) {
                    len = end - start + 1;
                    out = s.substring(start, end+1);
                }
                
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                start++;
            }
        }
        
        return out;
    }
    
    private boolean hasAllChars(Map<Character, Integer> container, 
                                Map<Character, Integer> target) {
        
        
        for (Map.Entry<Character, Integer> entry : target.entrySet()) {
            if (!container.containsKey(entry.getKey()) || 
               container.get(entry.getKey()) < entry.getValue())
                return false;
        }
        
        return true;
    }
    
}