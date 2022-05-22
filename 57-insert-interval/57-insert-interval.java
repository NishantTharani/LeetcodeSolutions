class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        int idx = 0;
        
        while (idx < intervals.length && newInterval[0] > list.get(idx)[0]) {
            idx++;
        }
    
        list.add(idx, newInterval);
            
        // Now repeat the merge intervals process for the entire list
        List<int[]> out = new ArrayList<>();
        int start = list.get(0)[0];
        int end = list.get(0)[1];
        
        for (int i = 1; i < list.size(); i++) {
            if (end < list.get(i)[0]) {
                out.add(new int[]{start, end});
                start = list.get(i)[0];
                end = list.get(i)[1];
            } else {
                end = Math.max(end, list.get(i)[1]);
            }
        }
        
        out.add(new int[]{start, end});
        
        return out.toArray(new int[out.size()][]);
    }
}