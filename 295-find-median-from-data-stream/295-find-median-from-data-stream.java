class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if (minHeap.size() == 0 || num > minHeap.peek()) {
            minHeap.add(num);
            if (minHeap.size() >= maxHeap.size() + 2) {
                maxHeap.add(minHeap.poll());
            }
        } else {
            maxHeap.add(num);
            if (maxHeap.size() >= minHeap.size() + 2) {
                minHeap.add(maxHeap.poll());
            }
        }
    }
    
    public double findMedian() {
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */