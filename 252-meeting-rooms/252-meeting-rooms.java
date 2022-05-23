class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length < 2 )
            return true;
        
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end)
                return false;
            
            end = intervals[i][1];
        }
        
        return true;
    }
}