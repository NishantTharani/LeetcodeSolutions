class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        for (Map.Entry<Character, Integer> e : map.entrySet())
            maxHeap.add(e);
        
        StringBuilder out = new StringBuilder();
        
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> e = maxHeap.poll();
            for (int i = 0; i < e.getValue(); i++) {
                out.append(e.getKey());
            }
        }
        
        return out.toString();
    }
}