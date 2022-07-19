class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 0)
            return new ArrayList<Integer>();
        
        if (n == 1) {
            List<Integer> out = new ArrayList<Integer>();
            out.add(0);
            return out;
        }
            
        // Create a adjacency list representation of this tree as an undirected graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> incoming = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
            incoming.put(i, 0);
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            incoming.put(edge[0], incoming.get(edge[0]) + 1);
            incoming.put(edge[1], incoming.get(edge[1]) + 1);
        }
        
        Queue<Integer> leaves = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (incoming.get(i) == 1)
                leaves.add(i);
        }
        
        while (n > 2) {
            int numLeaves = leaves.size();
            n -= numLeaves;
            
            for (int i = 0; i < numLeaves; i++) {
                int v = leaves.poll();
                incoming.put(v, incoming.get(v) - 1);
                for (int d : graph.get(v)) {
                    incoming.put(d, incoming.get(d) - 1);
                    if (incoming.get(d) == 1)
                        leaves.add(d);
                }
            }
        }
        
        return new ArrayList<Integer>(leaves);

    }
}


