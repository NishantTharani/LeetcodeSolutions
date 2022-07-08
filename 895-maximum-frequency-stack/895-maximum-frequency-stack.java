class FreqStack {
    class Triplet implements Comparable<Triplet> {
        int val;
        int freq;
        int idx;
        
        public Triplet(int val, int freq, int idx) {
            this.val = val;
            this.freq = freq;
            this.idx = idx;
        }
        
        @Override
        public int compareTo(Triplet other) {
            if (this.freq != other.freq) {
                return other.freq > this.freq ? 1 : -1;
            } else {
                return other.idx > this.idx ? 1 : -1;
            }
        }
    }
    
    PriorityQueue<Triplet> maxHeap;
    Map<Integer, Integer> map;
    int curr;

    public FreqStack() {
        map = new HashMap<>();
        maxHeap = new PriorityQueue<>();
        curr = 0;
    }
    
    public void push(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
        maxHeap.add(new Triplet(val, map.get(val), curr));
        curr++;
    }
    
    public int pop() {
        int out = maxHeap.poll().val;
        map.put(out, map.get(out) - 1);
        return out;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */