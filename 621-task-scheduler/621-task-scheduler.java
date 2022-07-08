class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> dummy = new HashMap<>();
        dummy.put('.', 0);
        Map.Entry<Character,Integer> d = dummy.entrySet().iterator().next();
        
        for (Character c : tasks)
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        
        maxHeap.addAll(map.entrySet());
        
        StringBuilder out = new StringBuilder();
        Queue<Map.Entry<Character,Integer>> tmp = new LinkedList<>();
        int extra = 0;
        int k = n+1;
        
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> e = maxHeap.poll();
            out.append(e.getKey());
            e.setValue(e.getValue() - 1);
            tmp.add(e);
            
            if (maxHeap.isEmpty()) {
                while (tmp.size() > 0 && tmp.peek().getValue() == 0)
                    tmp.poll();
                
                if (tmp.size() > 0 && tmp.size() < k) {
                    int blanks = k - tmp.size();
                    extra += blanks;
                    for (int i = 0; i < blanks; i++) {
                        tmp.add(d);
                    }
                }
            }
            
            if (tmp.size() == k) {
                e = tmp.poll();
                if (e.getValue() > 0)
                    maxHeap.add(e);
            }
        }
        
        return out.length() + extra;
        
    }
}