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
        
        int i = 1;
        int len = 1;
        int[] prev = intervals[0];
        int[] curr;
        while (i < intervals.length) {   
            curr = intervals[i];
            if (prev[1] < curr[0]) {
                prev = intervals[i];
                len++;
                i++;
            } else if (prev[1] >= curr[1]) {
                curr[0] = -1;
                curr[1] = -1;
                i++;
            } else if (prev[1] >= curr[0] && prev[1] < curr[1]) {
                prev[1] = curr[1];
                curr[0] = -1;
                curr[1] = -1;
                i++;
            }
        }
        
        // Create the output
        int[][] out = new int[len][];
        i = 0;
        for (int[] tmp : intervals) {
            if (tmp[0] != -1) {
                out[i] = tmp;
                i++;
            }
        }
        
        return out;
    }
}