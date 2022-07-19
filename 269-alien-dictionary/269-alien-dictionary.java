class Solution {
    public String alienOrder(String[] words) {
        // Convert the list of words into a list of prerequisite-pairs
        List<char[]> prereqs = new ArrayList<>();
        Set<Character> letters = new HashSet<>();
        
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray())
                letters.add(c);
            
            if (i > 0) {
                String first = words[i-1];
                String second = words[i];
                int minLength = Math.min(first.length(), second.length());

                boolean prereqAdded = false;
                for (int j = 0; j < minLength; j++) {
                    char a = first.charAt(j);
                    char b = second.charAt(j);
                    if (a != b) {
                        prereqs.add(new char[]{a, b});
                        prereqAdded = true;
                        break;
                    }
                }
                if (!prereqAdded && first.length() > second.length())
                    return "";
            }   
        }
        
        // Now find a topological ordering
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> incoming = new HashMap<>();
        
        for (char c : letters) {
            graph.put(c, new ArrayList<>());
            incoming.put(c, 0);
        }
        
        for (char[] prereq : prereqs) {
            graph.get(prereq[0]).add(prereq[1]);
            incoming.put(prereq[1], incoming.getOrDefault(prereq[1], 0) + 1);
        }
        
        int numKeys = letters.size();
        
        Queue<Character> sources = new LinkedList<>();
        StringBuilder out = new StringBuilder();
        
        for (int i = 97; i < 97 + 26; i++) {
            if (incoming.containsKey((char) i) && incoming.get((char) i) == 0)
                sources.add((char) i);
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



