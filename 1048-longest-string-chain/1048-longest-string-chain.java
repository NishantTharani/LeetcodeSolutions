class Solution {
    public int longestStrChain(String[] words) {
        // Track longest chain length
        int longestChain = 1;
    
        // Track longest word length
        int longestWord = Integer.MIN_VALUE;
        int shortestWord = Integer.MAX_VALUE;
        
        
        // Map length -> words
        Map<Integer,List<String>> lengthToWord = new HashMap<>();
        
        // Map word -> length of longest possible word chain starting at that word
        Map<String,Integer> wordToChain = new HashMap<>();
        
        // Initialize maps
        for (String word : words) {
            List<String> wordsOfLength = lengthToWord.getOrDefault(word.length(), new ArrayList<String>());
            wordsOfLength.add(word);
            lengthToWord.put(word.length(), wordsOfLength);
            
            wordToChain.put(word, 1);
            
            longestWord = Math.max(longestWord, word.length());
            shortestWord = Math.min(shortestWord, word.length());
        }
        
        // For each length from the greatest backwards:
        for (int length = longestWord; length >= shortestWord; length--) {
            for (String word : lengthToWord.getOrDefault(length, new ArrayList<String>())) {
                // For each word of that length + 1:
                for (String nextWord : lengthToWord.getOrDefault(length+1, new ArrayList<String>())) {
                    // If that word is a successor:
                    if (isSuccessor(word, nextWord)) {
                        // Update current word's longest possible chain
                        int chainLength = Math.max(wordToChain.get(word), wordToChain.get(nextWord) + 1);
                        wordToChain.put(word, chainLength);
                        // Update current longest possible chain estimate
                        longestChain = Math.max(longestChain, chainLength);
                    }
                }
            }
        }
        
        return longestChain;
        
    }
    
    private boolean isSuccessor(String word, String next) {
        // We can skip at most one letter
        boolean skipped = false;
        int i = 0;
        int j = 0;
        
        while (i < word.length()) {
            if (word.charAt(i) == next.charAt(j)) {
                i++;
                j++;
            } else {
                if (!skipped) {
                    skipped = true;
                    j++;
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
}

        
/*
Brainstorming:
    Make a directed graph. And then it's longest path in a directed graph?
    How to check if one string is the predecessor of another? Takes O(n^2) time where n is len(str)?
    Maybe start with the longest words and work backwards?
        Map each word to its length
        Then for each length from the greatest backwards:
            For each word in length + 1:
                If that word is a successor:
                    Update the current word's longest possible chain
                    Update current longest possible chain estimate
*/