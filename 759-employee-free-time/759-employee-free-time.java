/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> out = getReverse(schedule.get(0));
        
        for (int i = 1; i < schedule.size(); i++) {
            List<Interval> next = getReverse(schedule.get(i));
            out = getIntersection(out, next);
        }
        
        out.remove(0);
        out.remove(out.size() - 1);
        return out;
    }
    
    private List<Interval> getReverse(List<Interval> schedule) {
        List<Interval> out = new ArrayList<>();
        out.add(new Interval(Integer.MIN_VALUE, schedule.get(0).start));
        for (int i = 1; i < schedule.size(); i++) {
            out.add(new Interval(schedule.get(i-1).end, schedule.get(i).start));
        }
        out.add(new Interval(schedule.get(schedule.size() - 1).end, Integer.MAX_VALUE));
        return out;
    }
    
    private List<Interval> getIntersection(List<Interval> first, List<Interval> second) {
        int i = 0;
        int j = 0;
        List<Interval> out = new ArrayList<>();
        int start;
        int end;
        
        while (i < first.size() && j < second.size()) {
            if ((first.get(i).end > second.get(j).start) && (second.get(j).end > first.get(i).start)) {
                start = Math.max(first.get(i).start, second.get(j).start);
                end = Math.min(first.get(i).end, second.get(j).end);
                out.add(new Interval(start, end));
            }
            
            if (first.get(i).end < second.get(j).end) {
                i++;
            } else {
                j++;
            }
        }
        
        return out;
    }
}




