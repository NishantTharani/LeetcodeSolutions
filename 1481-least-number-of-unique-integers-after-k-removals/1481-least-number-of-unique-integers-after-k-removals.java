class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : arr)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        for (Map.Entry<Integer,Integer> e : map.entrySet()) {
            minHeap.add(e.getValue());
        }
        
        int out = map.size();
        int removed = 0;
        while (!minHeap.isEmpty() && removed + minHeap.peek() <= k) {
            removed += minHeap.poll();
            out--;
        }
        
        return out;
    }
}