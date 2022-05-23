class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        
        List<Integer> ends = new ArrayList<>();
        ends.add(intervals[0][1]);
        
        int start;
        int end;
        boolean added;
        for (int i = 1; i < intervals.length; i++) {
            start = intervals[i][0];
            end = intervals[i][1];
            added = false;
            
            for (int room = 0; room < ends.size(); room++) {
                if (start >= ends.get(room)) {
                    // This meeting can be scheduled in room
                    ends.set(room, end);
                    added = true;
                    break;
                }
            }
            
            if (!added) {
                // Meeting did not fit in any room: need a new room
                ends.add(end);
            }   
        }
        
        return ends.size();
    }
}