class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (Character c : tasks)
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        
        maxHeap.addAll(map.entrySet());
        
        Queue<Map.Entry<Character,Integer>> tmp = new LinkedList<>();
        int extra = 0;
        int k = n+1;
        int executed = 0;
        
        
        while (!maxHeap.isEmpty()) {
            int left = k;
            while (left > 0 && !maxHeap.isEmpty()) {
                Map.Entry<Character, Integer> e = maxHeap.poll();
                left--;
                if (e.getValue() > 1) {
                    e.setValue(e.getValue() - 1);
                    tmp.add(e);
                }
            }
            
            if (tmp.size() > 0) {
                maxHeap.addAll(tmp);
                tmp.clear();
                if (left > 0)
                    extra += left;
            }   
        }
        
        return tasks.length + extra;
        
    }
}