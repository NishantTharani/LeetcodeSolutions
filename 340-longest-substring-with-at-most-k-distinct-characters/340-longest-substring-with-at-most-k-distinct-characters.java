class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int max = 0;
        Map<Character, Integer> chars = new HashMap<Character, Integer>();
        int count = 0;
        int start = 0;
        
        for (int end = 0; end < s.length(); end++) {
            Character endChar = s.charAt(end);
            chars.put(endChar, chars.getOrDefault(endChar, 0) + 1);
            if (chars.get(endChar) == 1)
                count++;
            
            while (count > k) {
                Character startChar = s.charAt(start);
                chars.put(startChar, chars.get(startChar) - 1);
                if (chars.get(startChar) == 0)
                    count--;
                start++;
            }
            
            max = Math.max(max, end + 1 - start);
        }
        
        return max;
    }
}