class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length - k + 1;
        double[] out = new double[len];
        
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < k; i++) {
            add(min, max, nums[i]);
        }
        
        for (int i = 0; i < len; i++) {
            if (min.size() > max.size()) {
                out[i] = min.peek();
            } else if (max.size() > min.size()) {
                out[i] = max.peek();
            } else {
                out[i] = (0.5*min.peek()) + (0.5*max.peek());
            }
            
            remove(min, max, nums[i]);
            
            if (i < len - 1)
                add(min, max, nums[k+i]);
        }
        
        return out;
    }
    
    private void add(PriorityQueue<Integer> min, PriorityQueue<Integer> max, int num) {
        if (min.size() > 0 && num >= min.peek()) {
            min.add(num);
        } else if (max.size() > 0 && num <= max.peek()) {
            max.add(num);
        } else {
            min.add(num);
        }
        
        if (min.size() >= max.size() + 2) {
            max.add(min.poll());
        } else if (max.size() >= min.size() + 2) {
            min.add(max.poll());
        }
    }
    
    private void remove(PriorityQueue<Integer> min, PriorityQueue<Integer> max, int num) {
        if (num >= min.peek()) {
            min.remove(num);
            if (max.size() >= min.size() + 2) {
                min.add(max.poll());
            }
        } else {
            max.remove(num);
            if (min.size() >= max.size() + 2) {
                max.add(min.poll());
            }
        }
        
        
    }
    
}