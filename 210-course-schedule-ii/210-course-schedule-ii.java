class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] out = new int[numCourses];
        int idx = 0;
        Map<Integer,List<Integer>> graph = new HashMap<>();
        Map<Integer,Integer> incoming = new HashMap<>();
        
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
            incoming.put(i, 0);
        }
        
        for (int[] prereq : prerequisites) {
            graph.get(prereq[1]).add(prereq[0]);
            incoming.put(prereq[0], incoming.get(prereq[0]) + 1);
        }
        
        Queue<Integer> sources = new LinkedList<>();
        for (int key : incoming.keySet()) {
            if (incoming.get(key) == 0)
                sources.add(key);
        }
        
        while (!sources.isEmpty()) {
            int v = sources.poll();
            out[idx] = v;
            idx++;
            // Delete v from graph: for our purposes, just decrement in-degree of courses it points to
            for (int c : graph.get(v)) {
                incoming.put(c, incoming.get(c) - 1);
                if (incoming.get(c) == 0)
                    sources.add(c);
            }
        }
        
        if (idx == numCourses) {
            return out;
        } else {
            return new int[0];
        }
    }
}