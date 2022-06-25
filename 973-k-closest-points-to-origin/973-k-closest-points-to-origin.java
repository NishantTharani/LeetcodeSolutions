class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new pointComparator());
        
        for (int i = 0; i < k; i++)
            maxHeap.add(points[i]);
        
        for (int i = k; i < points.length; i++) {
            int[] p = points[i];
            int[] p2 = maxHeap.peek();
            if (dist(p[0], p[1]) < dist(p2[0], p2[1])) {
                maxHeap.poll();
                maxHeap.add(p);
            }
        }
        
        int[][] out = new int[k][];
        
        for (int i = 0; i < k; i++) {
            out[i] = maxHeap.poll();
        }
        
        return out;
    }
    
    private double dist(int x, int y) {
        return Math.sqrt((x*x) + (y*y));
    }
    
    class pointComparator implements Comparator<int[]> {
        public int compare(int[] p1, int[] p2) {
            Double d1 = dist(p1[0], p1[1]);
            Double d2=  dist(p2[0], p2[1]);
            return d2.compareTo(d1);
        }
    } 
}