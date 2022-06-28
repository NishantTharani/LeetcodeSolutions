class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Pair<Integer,Integer>> minHeap = new PriorityQueue<>((p1, p2) -> p1.getValue() - p2.getValue());
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Pair<Integer, Integer> p = new Pair(entry.getKey(), entry.getValue());
            
            if (minHeap.size() < k) {
                minHeap.add(p);
            } else if (p.getValue() > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.add(p);
            }
        }
        
        int[] out = new int[minHeap.size()];
        int i = 0;
        
        while (minHeap.size() > 0) {
            out[i] = minHeap.poll().getKey();
            i++;
        }
        
        return out;
    }
    
    
}