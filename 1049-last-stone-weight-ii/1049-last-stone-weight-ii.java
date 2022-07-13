class Solution {
    int sum;
    
    public int lastStoneWeightII(int[] stones) {
        this.sum = 0;
        for (int  i : stones)
            this.sum += i;
        
        Map<Pair<Integer,Integer>,Integer> map = new HashMap<>();
        
        return bruteForce(stones, 0, 0, map);
    }
    
    private int bruteForce(int[] stones, int idx, int left, Map<Pair<Integer,Integer>,Integer> map) {
        if (idx == stones.length) {
            return Math.abs(this.sum - left - left);
        }
        
        Pair<Integer,Integer> key = new Pair<>(idx, left);
        if (map.containsKey(key))
            return map.get(key);
        
        int goLeft = bruteForce(stones, idx+1, left+stones[idx], map);
        int goRight = bruteForce(stones, idx+1, left, map);
        int out = Math.min(goLeft, goRight);
        map.put(key, out);
        return out;
    }
}