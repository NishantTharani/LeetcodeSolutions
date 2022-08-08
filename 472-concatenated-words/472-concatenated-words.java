class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words)
            set.add(word);
        
        List<String> out = new ArrayList<>();
        
        for (String word : words) {
            boolean[] isConcat = new boolean[word.length() + 1];
            isConcat[0] = true;
            
            for (int end = 1; end < word.length(); end++) {
                for (int start = 0; start < end; start++) {
                    String sub = word.substring(start, end);
                    if (set.contains(sub) && isConcat[start]) {
                        isConcat[end] = true;
                        break;
                    }
                }
            }
            
            for (int start = 1; start < word.length(); start++) {
                String sub = word.substring(start, word.length());
                if (set.contains(sub) && isConcat[start]) {
                    out.add(word);
                    break;
                }
            }
        }
        
        return out;
    }
}