class Solution {
    public int[][] merge(int[][] intervals) {
        /*
        Given two intervals: a,b and c,d , where a <= c
            c > b : the intervals are not overlapping. save a,b and move on
            b >= c : the intervals merge into a,max(b,d)
        */
        
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        
        List<int[]> out = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++) {
            int c = intervals[i][0];
            int d = intervals[i][1];
            
            if (c > end) {
                out.add(new int[]{start, end});
                start = c;
                end = d;
            } else {
                end = Math.max(end, d);
            }
        }
        
        out.add(new int[]{start, end});
        
        int[][] out2 = new int[out.size()][];
        out.toArray(out2);
        return out2;
    }
}