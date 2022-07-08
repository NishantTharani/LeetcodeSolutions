class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] out = new int[]{0, Integer.MAX_VALUE};
        int k = nums.size();
        int max = Integer.MIN_VALUE;
        int[] idxs = new int[k];
        
        PriorityQueue<Pair<Integer,Integer>> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.getValue(), p2.getValue()));
                
        for (int i = 0; i < k; i++) {
            minHeap.add(new Pair<Integer,Integer>(i, nums.get(i).get(0)));
            max = Math.max(max, nums.get(i).get(0));
            idxs[i] = 1;
        }
        
        while (minHeap.size() == k) {
            Pair<Integer,Integer> minPair = minHeap.poll();
            int min = minPair.getValue();
            
            if (max - min < out[1] - out[0]) {
                out[1] = max;
                out[0] = min;
            }
            
            if (idxs[minPair.getKey()] < nums.get(minPair.getKey()).size()) {
                minHeap.add(new Pair<Integer,Integer>(minPair.getKey(), nums.get(minPair.getKey()).get(idxs[minPair.getKey()])));
                max = Math.max(max, nums.get(minPair.getKey()).get(idxs[minPair.getKey()]));
                idxs[minPair.getKey()]++;
            }
        }
        
        return out;
    }
}