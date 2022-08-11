class Solution {
    public int characterReplacement(String s, int k) {
        int out = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        
        for (int end = 0; end < s.length(); end++) {
            Character c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            max = Math.max(max, map.get(c));
            
            while (end + 1 - start - max > k) {
                c = s.charAt(start);
                map.put(c, map.get(c) - 1);
                start++;
            }

            out = Math.max(out, end - start + 1);
        }
        
        return out;
    }
}
    