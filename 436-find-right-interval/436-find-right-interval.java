class Solution {
    public int[] findRightInterval(int[][] intervals) {
        PriorityQueue<Interval> byStart = new PriorityQueue<>(new startComparator());
        PriorityQueue<Interval> byEnd = new PriorityQueue<>(new endComparator());
        
        for (int i = 0; i < intervals.length; i++) {
            Interval tmp = new Interval(intervals[i][0], intervals[i][1], i);
            byStart.add(tmp);
            byEnd.add(tmp);
        }
        
        int[] out = new int[intervals.length];
        
        while (byEnd.size() > 0) {
            Interval toFill = byEnd.poll();
            
            while (byStart.size() > 0 && byStart.peek().start < toFill.end) {
                byStart.poll();
            }
            
            if (byStart.size() == 0) {
                out[toFill.idx] = -1;
            } else {
                out[toFill.idx] = byStart.peek().idx;
            }
        }
        
        return out;
    }
    
    class Interval {
        public int start;
        public int end;
        public int idx;
        
        public Interval(int start, int end, int idx) {
            this.start = start;
            this.end = end;
            this.idx = idx;
        }
    }
    
    class startComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval i1, Interval i2) {
            return Integer.compare(i1.start, i2.start);
        }
    }
    
    class endComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval i1, Interval i2) {
            return Integer.compare(i1.end, i2.end);
        }
    }
}


/*
    One heap where intervals are drawn from in ascending order of ends: min heap
    Another heap where intervals are drawn from in ascending order of starts: min heap
    Interval object consists of start, end, and index
*/