class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        int n = intervals.length;
        int i = 0;
        
        while (i < n && newInterval[0] > list.get(i)[0]) {
            i++;
        }
        
        // If we add newInterval at index i now, list will be sorted by the interval starts, in non-descending order
        list.add(i, newInterval);
        
        // Now repeat the merge intervals process for the entire list
        List<int[]> out = new ArrayList<>();
        n = list.size();
        int start = list.get(0)[0];
        int end = list.get(0)[1];
        i = 1;
        
        while (i < n) {
            if (end < list.get(i)[0]) {
                out.add(new int[]{start, end});
                start = list.get(i)[0];
                end = list.get(i)[1];
                i++;
            } else {
                end = Math.max(end, list.get(i)[1]);
                i++;
            }
        }
        
        out.add(new int[]{start, end});
        
        return out.toArray(new int[out.size()][]);
    }
}