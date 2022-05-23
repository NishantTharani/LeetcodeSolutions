class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        
        List<List<int[]>> rooms = new ArrayList<>();
        rooms.add(new ArrayList<>());
        rooms.get(0).add(new int[]{intervals[0][0], intervals[0][1]});
        
        List<Integer> pos = new ArrayList<>();
        pos.add(0);
        

        int p;
        boolean added;
        for (int i = 1; i < intervals.length; i++) {
            added = false;
            
            for (int room = 0; room < pos.size(); room++) {
                p = pos.get(room);
                if (intervals[i][0] >= rooms.get(room).get(p)[1]) {
                    // This meeting can be scheduled in room
                    rooms.get(room).add(new int[]{intervals[i][0], intervals[i][1]});
                    pos.set(room, p + 1);
                    added = true;
                    break;
                }
            }
            
            if (!added) {
                // Meeting did not fit in any room: need a new room
                rooms.add(new ArrayList<>());
                rooms.get(rooms.size() - 1).add(new int[]{intervals[i][0], intervals[i][1]});
                pos.add(0);
            }   
        }
        
        return pos.size();
    }
}