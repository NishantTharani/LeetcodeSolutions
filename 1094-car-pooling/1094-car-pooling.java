class Solution {
    public boolean carPooling(int[][] trips, int capacity) {        
        Arrays.sort(trips, Comparator.comparingInt(o -> o[1]));
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        
        int used = 0;
        
        for (int i = 0; i < trips.length; i++) {
            while (pq.size() > 0 && trips[i][1] >= pq.peek()[0]) {
                used -= pq.poll()[1];
            }
            
            pq.add(new int[]{trips[i][2], trips[i][0]});
            used += trips[i][0];
            
            if (used > capacity)
                return false;
        }
        
        return true;
    }
}