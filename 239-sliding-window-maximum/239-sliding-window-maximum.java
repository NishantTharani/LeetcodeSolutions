class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer,Integer> map = new HashMap<>();
        int[] out = new int[nums.length - k + 1];
        
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) == 1)
                maxHeap.add(nums[i]);
        }
        
        out[0] = maxHeap.peek();
        
        for (int end = k; end < nums.length; end++) {
            int start = end - k;
            map.put(nums[start], map.get(nums[start]) - 1);
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            
            if (map.get(nums[end]) == 1)
                maxHeap.add(nums[end]);
            
            while (map.get(maxHeap.peek()) == 0)
                maxHeap.poll();
            
            out[start+1] = maxHeap.peek();
        }
        
        return out;
    }
}