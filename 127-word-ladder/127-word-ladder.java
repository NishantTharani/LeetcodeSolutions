class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        wordList.add(beginWord);
        
        for (int i = 0; i < wordList.size(); i++)
            graph.put(i, new ArrayList<>());
        
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (almostEqual(wordList.get(i), wordList.get(j))) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        
        // Run BFS
        Queue<Integer> queue = new LinkedList<>();
        int level = 0;
        boolean[] visited = new boolean[wordList.size()];
        queue.add(wordList.size() - 1);
        visited[wordList.size() - 1] = true;
        
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int v = queue.poll();
                if (wordList.get(v).equals(endWord))
                    return level + 1;
                for (int next : graph.get(v)) {
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                    }
                }
            }
            level++;
        }
        
        return 0;
        
        
    }
    
    private boolean almostEqual(String s1, String s2) {
        boolean diff = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (diff)
                    return false;
                else
                    diff = true;
            }
        }
        return diff;
    }
}