class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        // Put the head of each list into a minHeap and a maxHeap
        // At each step, check the range between the top of each heap and update the smallest range if necessary
        // Then poll the top of each heap and replace it with the next element in the list that element came from
        
        int k = nums.size();
        int[] idxs = new int[k];
        PriorityQueue<Pair<Integer,Integer>> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.getKey(), p2.getKey()));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < k; i++) {
            minHeap.add(new Pair<Integer,Integer>(nums.get(i).get(0), i));
            maxHeap.add(nums.get(i).get(0));
            idxs[i] = 1;
        }
        
        int[] out = new int[2];
        out[0] = minHeap.peek().getKey();
        out[1] = maxHeap.peek();
        
        while (minHeap.size() == k) {
            Pair<Integer,Integer> minPair = minHeap.poll();
            int min = minPair.getKey();
            int max = maxHeap.peek();
            
            if (max - min < out[1] - out[0]) {
                out[0] = min;
                out[1] = max;
            }
            
            int j = minPair.getValue();
            if (idxs[j] < nums.get(j).size()) {
                minHeap.add(new Pair<Integer,Integer>(nums.get(j).get(idxs[j]), j));
                maxHeap.add(nums.get(j).get(idxs[j]));
                idxs[j]++;
            }
        }
        
        return out;
    }
}