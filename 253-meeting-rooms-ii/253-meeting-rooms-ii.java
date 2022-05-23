class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        
        PriorityQueue<Integer> ends = new PriorityQueue<>();
        ends.add(intervals[0][1]);
        
        int start;
        int end;
        boolean added;
        for (int i = 1; i < intervals.length; i++) {
            start = intervals[i][0];
            end = intervals[i][1];
            
            if (start >= ends.peek()) {
                // Replace the min value with end
                ends.poll();
                ends.add(end);
            } else {
                // Meeting needs a new room
                ends.add(end);
            }
        }
        
        return ends.size();
    }
}