class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] val = new boolean[s.length() + 1];
        val[0] = true;
        
        for (int end = 1; end <= s.length(); end++) {
            for (int start = 0; start < end; start++) {
                if (set.contains(s.substring(start, end)) && val[start]) {
                    val[end] = true;
                    break;
                }
            }
        }
        
        return val[s.length()];
    }
}