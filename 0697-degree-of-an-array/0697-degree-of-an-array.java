class Solution {
    class Num {
        public int first;
        public int last;
        public int count;
        public Num(int first) {
            this.first = first;
            this.last = first;
            this.count = 1;
        }
    }
    
    public int findShortestSubArray(int[] nums) {
        int out = nums.length;
        int maxCount = 1;
        
        // Map int -> (first occurrence, last occurrence, count)
        Map<Integer,Num> map = new HashMap<>();
        
        
        // Fill out the map and keep track of largest count
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                Num curr = map.get(num);
                curr.last = i;
                curr.count++;
                maxCount = Math.max(maxCount, curr.count);
            } else {
                Num curr = new Num(i);
                map.put(num, curr);
                maxCount = Math.max(maxCount, curr.count);
            }
        }
        
        // A pass through the map where we check out every integer with maxCount appearances
        for (Map.Entry<Integer,Num> entry : map.entrySet()) {
            Num curr = entry.getValue();
            if (curr.count == maxCount) {
                out = Math.min(out, curr.last - curr.first + 1);
            }
        }
        
        return out;
    }
}