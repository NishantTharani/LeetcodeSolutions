class Solution {
    public int numTrees(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return recNumTrees(n, map);
    }
    
    private int recNumTrees(int n, Map<Integer, Integer> map) {
        if (n == 0)
            return 1;
        
        if (map.containsKey(n))
            return map.get(n);
        
        int out = 0;
        
        for (int i = 1; i <= n; i++) {
            out += recNumTrees(i-1, map) * recNumTrees(n-i, map);
        }
        
        map.put(n, out);
        
        return out;
    }
}