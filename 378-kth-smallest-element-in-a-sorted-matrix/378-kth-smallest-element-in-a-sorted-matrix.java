class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Pair<Integer,Integer>> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(matrix[p1.getKey()][p1.getValue()], matrix[p2.getKey()][p2.getValue()]));
        
        for (int i = 0; i < matrix.length; i++) {
            minHeap.add(new Pair<Integer,Integer>(i,0));
        }
        
        for (int i = 1; i < k; i++) {
            Pair<Integer,Integer> min = minHeap.poll();
            if (min.getValue() < matrix.length - 1) {
                minHeap.add(new Pair<Integer,Integer>(min.getKey(), min.getValue() + 1));
            }
        }
        
        Pair<Integer,Integer> min = minHeap.peek();
        return matrix[min.getKey()][min.getValue()];
    }
}