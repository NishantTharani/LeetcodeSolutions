class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            if (map.get(s.charAt(i)) > (s.length() + 1)/2) {
                return "";
            }
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            maxHeap.add(e);
        }
        
        char[] out = new char[s.length()];
        int idx = 0;
        Map.Entry<Character, Integer> curr;
        
        while (!maxHeap.isEmpty()) {
            curr = maxHeap.poll();
            for (int i = 0; i < curr.getValue(); i++) {
                out[idx] = curr.getKey();
                idx += 2;
                
                if (idx >= s.length()) {
                    idx = 1;
                }
            }
        }
        
        return new String(out);
        
    }
}


