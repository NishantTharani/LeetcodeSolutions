class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Try to build a topological ordering and see if we succeed
        
        // First convert the graph to an adjacency list representation and get a map showing the in-degree of each vertex
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> incoming = new HashMap<>();
        
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
            incoming.put(i, 0);
        }
        
        for (int[] edge : prerequisites) {
            graph.get(edge[0]).add(edge[1]);
            incoming.put(edge[1], incoming.get(edge[1]) + 1);
        }
        
        // We will try to build a topological ordering
        Queue<Integer> sources = new LinkedList<>();
        List<Integer> out = new ArrayList<>();
        
        for (Integer v : incoming.keySet()) {
            if (incoming.get(v) == 0)
                sources.add(v);
        }
        
        while (!sources.isEmpty()) {
            Integer source = sources.poll();
            out.add(source);
            for (int dest : graph.get(source)) {
                incoming.put(dest, incoming.get(dest) - 1);
                if (incoming.get(dest) == 0)
                    sources.add(dest);
            }
        }
        
        if (out.size() == numCourses) {
            return true;
        } else {
            return false;
        }
            
    }
}