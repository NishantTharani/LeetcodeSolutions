class Solution {
    public int[][] merge(int[][] intervals) {
        /* Say two intervals are a,b and i,j
        Six cases:
            b <= i: first interval is before second: prepend and break
            a >= j: first interval is after second: append and move on
            a >= i and b <= j: second interval contains the first: ignore and move on
            a <= i and b >= j: first interval contains the second
                here we prepend the new one, delete the old one, but keep going in case other cases apply to later intervals too
            a <= i and b <= j: they overlap. merge and move on
            a >= i and a <= j and b >= j: they overlap. 
                merge. and keep going in case other cases apply to later intervals too
     
        */
        
        // Sort the intervals on their start time
        Arrays.sort(intervals, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        
        /* Now we can check two consecutive intervals a,b and j,k and only have cases:
            b < j: do nothing and update the first interval
            b >= k: delete j,k and keep the first interval the same
            a <= j and b > j and b < k: set b = k, delete j,k, keep the first interval the same
        */
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> out = new ArrayList<>();
        
        for (int i = 1; i < intervals.length; i++) {
            if (end >= intervals[i][0]) {
                end = Math.max(end, intervals[i][1]);
            } else {
                out.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        
        out.add(new int[]{start, end});
        
        return out.toArray( new int[out.size()][]);
    }
}