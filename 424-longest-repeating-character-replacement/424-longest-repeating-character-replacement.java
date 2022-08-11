class Solution {
    public int characterReplacement(String s, int k) {
        int out = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        
        for (int end = 0; end < s.length(); end++) {
            Character c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            while (end + 1 - start - max(map) > k) {
                c = s.charAt(start);
                map.put(c, map.get(c) - 1);
                start++;
            }

            out = Math.max(out, end - start + 1);
        }
        
        return out;
    }
    
    private int max(Map<Character, Integer> map) {
        int out = 0;
        
        for (char c : map.keySet())
            out = Math.max(out, map.get(c));
        
        return out;
    }
}