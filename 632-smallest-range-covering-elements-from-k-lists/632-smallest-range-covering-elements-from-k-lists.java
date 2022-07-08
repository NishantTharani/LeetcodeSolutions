class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] out = new int[]{0, Integer.MAX_VALUE};
        int k = nums.size();
        int max = Integer.MIN_VALUE;
        
        PriorityQueue<Pair<Integer,Integer>> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(nums.get(p1.getKey()).get(p1.getValue()), nums.get(p2.getKey()).get(p2.getValue())));
                
        for (int i = 0; i < k; i++) {
            minHeap.add(new Pair<Integer,Integer>(i,0));
            max = Math.max(max, nums.get(i).get(0));
        }
        
        while (minHeap.size() == k) {
            Pair<Integer,Integer> minPair = minHeap.poll();
            int min = nums.get(minPair.getKey()).get(minPair.getValue());
            
            if (max - min < out[1] - out[0]) {
                out[1] = max;
                out[0] = min;
            }
            
            if (minPair.getValue() < nums.get(minPair.getKey()).size() - 1) {
                minHeap.add(new Pair<Integer,Integer>(minPair.getKey(), minPair.getValue()+1));
                max = Math.max(max, nums.get(minPair.getKey()).get(minPair.getValue()+1));
            }
        }
        
        return out;
    }
}