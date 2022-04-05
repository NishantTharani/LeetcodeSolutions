class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordLength = words[0].length();
        int numWords = words.length;
        int matched = 0;
        List<Integer> out = new LinkedList<>();
        
        Map<String, Integer> freq = new HashMap<>();
        Map<String, Integer> seen = new HashMap<>();
        
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        
        for (int start = 0; start <= s.length() - (wordLength*numWords); start++) {
            seen.clear();
            matched = 0;
            int subStart = start;
            
            for (int i = 0; i < numWords; i++) {
                String sub = s.substring(subStart, subStart + wordLength);
                seen.put(sub, seen.getOrDefault(sub, 0) + 1);
                if (seen.get(sub) > freq.getOrDefault(sub, 0))
                    break;
                matched++;
                
                if (matched == numWords) {
                    out.add(start);
                    break;
                }
                
                subStart += wordLength;
            }
        }
        
        return out;
    }
}