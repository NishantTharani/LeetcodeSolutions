class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int rooms = 0;
        int maxRooms = 0;
        int s = 0;
        int e = 0;
        
        while (s < starts.length && e < ends.length) {
            if (starts[s] < ends[e]) {
                rooms++;
                maxRooms = Math.max(rooms, maxRooms);
                s++;
            } else {
                rooms--;
                e++;
            }
        }
        
        return maxRooms;
    }
}