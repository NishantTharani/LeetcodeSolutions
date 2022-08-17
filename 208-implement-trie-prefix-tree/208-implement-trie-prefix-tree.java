class Trie {
    Map<Character, Map> map;

    public Trie() {
        this.map = new HashMap<>();
    }
    
    public void insert(String word) {
        Map<Character, Map> currMap = this.map;
        
        for (Character c : word.toCharArray()) {
            if (!currMap.containsKey(c))
                currMap.put(c, new HashMap<Character, Map>());
            currMap = currMap.get(c);
        }
        
        currMap.put('.', null);
    }
    
    public boolean search(String word) {
        Map<Character, Map> currMap = this.map;
        
        for (Character c : word.toCharArray()) {
            if (!currMap.containsKey(c))
                return false;
            currMap = currMap.get(c);
        }
        
        if (!currMap.containsKey('.'))
            return false;
        
        return true;
    }
    
    public boolean startsWith(String prefix) {
        Map<Character, Map> currMap = this.map;
        
        for (Character c : prefix.toCharArray()) {
            if (!currMap.containsKey(c))
                return false;
            currMap = currMap.get(c);
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */