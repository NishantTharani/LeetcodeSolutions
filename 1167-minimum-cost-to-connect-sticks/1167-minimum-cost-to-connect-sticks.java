class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int stick : sticks)
            minHeap.add(stick);
        
        int out = 0;
        int nextStick;
        
        while (minHeap.size() > 1) {
            nextStick = minHeap.poll();
            nextStick += minHeap.poll();
            minHeap.add(nextStick);
            out += nextStick;
        }
        
        return out;
    }
}