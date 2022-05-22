class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> out = new ArrayList<>();
        int i = 0;
        
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            out.add(intervals[i]);
            i++;
        }
        
        if (i >= intervals.length) {
            out.add(newInterval);
            return out.toArray(new int[out.size()][]);
        }
        
        // Go through all the intervals our new interval overlaps with
        int start = Math.min(newInterval[0], intervals[i][0]);
        int end = newInterval[1];
        
        while (i < intervals.length && end >= intervals[i][0]) {
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        
        out.add(new int[]{start, end});
        
        while (i < intervals.length) {
            out.add(intervals[i]);
            i++;
        }
        
        return out.toArray(new int[out.size()][]);
    }
}