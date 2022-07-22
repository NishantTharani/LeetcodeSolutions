class Solution {
    public String alienOrder(String[] words) {
        // Convert the list of words into a list of prerequisite-pairs
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> incoming = new HashMap<>();
        
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.put(c, new ArrayList<>());
                incoming.put(c, 0);
            }
        }
        
        for (int i = 1; i < words.length; i++) {            
            String first = words[i-1];
            String second = words[i];
            int minLength = Math.min(first.length(), second.length());

            boolean prereqAdded = false;
            for (int j = 0; j < minLength; j++) {
                char a = first.charAt(j);
                char b = second.charAt(j);
                if (a != b) {
                    graph.get(a).add(b);
                    incoming.put(b, incoming.get(b) + 1);
                    prereqAdded = true;
                    break;
                }
            }
            if (!prereqAdded && first.length() > second.length())
                return "";
        }
        
        int numKeys = incoming.keySet().size();
        
        Queue<Character> sources = new LinkedList<>();
        StringBuilder out = new StringBuilder();
        
        for (Character c : incoming.keySet()) {
            if (incoming.get(c) == 0)
                sources.add(c);
        }
        
        while (!sources.isEmpty()) {
            char v = sources.poll();
            out.append(v);
            for (char dest : graph.get(v)) {
                incoming.put(dest, incoming.get(dest) - 1);
                if (incoming.get(dest) == 0)
                    sources.add(dest);
            }
        }
        
        if (out.length() == numKeys) {
            return out.toString();
        } else {
            return "";
        }
    }
}



