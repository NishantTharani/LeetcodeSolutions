class Solution {
    public String rearrangeString(String s, int k) {
        if (k == 0)
            return s;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        
        maxHeap.addAll(map.entrySet());
        
        StringBuilder out = new StringBuilder();
        Queue<Map.Entry<Character, Integer>> tmp = new LinkedList<>();
        
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> e = maxHeap.poll();
            out.append(e.getKey());
            
            e.setValue(e.getValue() - 1);
            tmp.add(e);
            
            
            if (tmp.size() == k) {
                e = tmp.poll();
                if (e.getValue() > 0)
                    maxHeap.add(e);
            }
            
    
        }
        
        if (out.length() < s.length())
            return "";
        
        return out.toString();
    }
}

// k=2: threshold is (n+1)/2
// k=3: threshold is (n+2)/3
// k=4: threshold is (n+3)/4