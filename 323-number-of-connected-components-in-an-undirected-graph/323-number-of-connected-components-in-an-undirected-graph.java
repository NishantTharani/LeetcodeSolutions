class Solution {
    public int countComponents(int n, int[][] edges) {
        // Adjacency list representation
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++)
            graph.put(i, new ArrayList<>());
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        int out = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                out++;
                stack.push(i);
                
                while (!stack.isEmpty()) {
                    int v = stack.pop();
                    visited[v] = true;
                    for (int d : graph.get(v))
                        if (!visited[d])
                            stack.push(d);
                }
            }
        }
        
        return out;
    }
}