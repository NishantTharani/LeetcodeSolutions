class AutocompleteSystem {
    TrieNode root;
    String[] sentences;
    TrieNode searchCurr;
    StringBuilder next;

    public AutocompleteSystem(String[] sentences, int[] times) {
        this.root = new TrieNode();
        this.searchCurr = root;
        this.sentences = sentences;
        this.next = new StringBuilder();
        
        for (int i = 0; i < sentences.length; i++) {
            TrieNode curr = root;
            String sentence = sentences[i];
            for (int j = 0; j < sentence.length(); j++) {
                char c = sentence.charAt(j);
                curr = curr.addChar(c);
                curr.addSentence(sentences[i], times[i]);
            }
        }
    }
    
    public List<String> input(char c) {
        if (c == '#') {
            this.searchCurr = this.root;
            String next = this.next.toString();
            this.next = new StringBuilder();
            TrieNode curr = this.root;
            for (int j = 0; j < next.length(); j++) {
                char d = next.charAt(j);
                curr = curr.addChar(d);
                curr.addSentence(next, 1);
            }
            return new ArrayList<>();
        }
        
        this.next.append(c);
        
        searchCurr = searchCurr.addChar(c);
        return searchCurr.getTopThree();
    }
    
    class TrieNode {
        Map<Character, TrieNode> map;
        Map<String, Integer> freq;
        
        public TrieNode() {
            this.map = new HashMap<>();
            this.freq = new HashMap<>();
        }
        
        public TrieNode addChar(Character c) {
            if (map.containsKey(c)) {
                return map.get(c);
            } else {
                TrieNode out = new TrieNode();
                map.put(c, out);
                return out;
            }
        }
        
        public void addSentence(String sentence, int count) {
            this.freq.put(sentence, this.freq.getOrDefault(sentence, 0) + count);
        }
        
        public List<String> getTopThree() {
            PriorityQueue<Pair<String,Integer>> pq = new PriorityQueue<>(new Comparator<Pair<String,Integer>>() {
                public int compare(Pair<String,Integer> p1, Pair<String,Integer> p2) {
                    if (p2.getValue() != p1.getValue()) {
                        return p2.getValue() - p1.getValue();
                    } else {
                        return p1.getKey().compareTo(p2.getKey());
                    }
                }
            });
            
            for (Map.Entry<String,Integer> e : this.freq.entrySet()) {
                pq.add(new Pair<String,Integer>(e.getKey(), e.getValue()));
            }
            
            List<String> out = new ArrayList<>();
            int i = 0;
            while (i < 3 && !pq.isEmpty()) {
                out.add(pq.poll().getKey());
                i++;
            }
            
            return out;
        }
        
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */

/*
Some ingredients of this system:
    a prefix tree aka trie type structure to use for lookups - or at least the idea of a map of maps
    a stringbuilder that keeps track of the characters typed so far
    
    a normal trie just tells you if there is a sentence starting with these characters, and if a specific sentence exists, through a map of maps type structure
    maybe I can expand it to include the actual sentences by storing them in a heap that's keyed  to a special character of the map?
    but then each sentence would get stored multiple times in successive heaps, which seems inefficient
    maybe instead of storing the sentences, I can just store the indices of the sentences in the dictionary
    
    so I have the same Map<Character, Map> structure
    actually, it has to be a Map<Character, (Heap, Map)> structure
    where the Heap has indices of all the sentences that start with the characters so far, keyed by their frequency

*/