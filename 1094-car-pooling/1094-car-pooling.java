class Solution {
    public boolean carPooling(int[][] trips, int capacity) {        
        int[][] starts = new int[trips.length][];
        int[][] ends = new int[trips.length][];
        
        for (int i = 0; i < trips.length; i++) {
            starts[i] = new int[]{trips[i][1], trips[i][0]};
            ends[i] = new int[]{trips[i][2], trips[i][0]};
        }
        
        Arrays.sort(starts, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(ends, Comparator.comparingInt(o -> o[0]));
        
        int s = 0;
        int e = 0;
        int used = 0;
        
        while (s < starts.length && e < ends.length) {
            if (starts[s][0] < ends[e][0]) {
                used += starts[s][1];
                if (used > capacity)
                    return false;
                s++;
            } else {
                used -= ends[e][1];
                e++;
            }
        }
        
        return true;
    }
}