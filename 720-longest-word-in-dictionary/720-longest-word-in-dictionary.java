class Solution {
    public String longestWord(String[] words) {
        Trie trie = new Trie(words);
        for (int i = 0; i < words.length; i++)
            trie.insert(words[i], i);
        return trie.answerSearch();
    }
    
    private class Node {
        char c;
        int index;
        HashMap<Character, Node> children;
        
        public Node(char c) {
            this.c = c;
            this.children = new HashMap<>();
            this.index = -1;
        }
    }
    
    private class Trie {
        Node root;
        String[] words;
        
        public Trie(String[] words) {
            this.root = new Node('0');
            this.words = words;
        }
        
        public void insert(String s, int index) {
            Node curr = root;
            for (char c : s.toCharArray()) {
                curr.children.putIfAbsent(c, new Node(c));
                curr = curr.children.get(c);
            }
            curr.index = index;
        }
        
        public String answerSearch() {
            String out = "";
            String word;
            Node curr;
            Node next;
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            
            while (!stack.isEmpty()) {
                curr = stack.pop();
                for (Character key : curr.children.keySet()) {
                    next = curr.children.get(key);
                    if (next.index >= 0)
                        stack.push(next);
                }
                
                if (curr.index >= 0) {
                    word = this.words[curr.index];
                    if (word.length() > out.length() || (word.length() == out.length() && word.compareTo(out) < 0))
                        out = word;
                }
            }
            
            return out;
        }
    }
}