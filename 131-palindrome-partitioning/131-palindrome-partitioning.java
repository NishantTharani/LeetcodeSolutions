class Solution {
    public List<List<String>> partition(String s) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = s.length();
        
        for (int i = 0; i < n; i++)
            map.put(i, new ArrayList<>());
        
        for (int i = 0; i < n; i++) {
            int left = i;
            int right = i;
            
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                map.get(left).add(right);
                left--;
                right++;
            }
            
            left = i;
            right = i+1;
            
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                map.get(left).add(right);
                left--;
                right++;
            }
        }
        
        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> start = new ArrayList<>();
        start.add(0);
        queue.add(start);
        List<List<String>> out = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            List<Integer> curr = queue.poll();
            int idx = curr.get(curr.size() - 1);
            
            if (idx == n) {
                // Convert into a partition and store in out
                List<String> partition = new ArrayList<>();
                for (int i = 0; i < curr.size() - 1; i++) {
                    partition.add(s.substring(curr.get(i), curr.get(i+1)));
                }
                out.add(partition);
            } else {
                for (int end : map.get(idx)) {
                    List<Integer> next = new ArrayList<>(curr);
                    next.add(end + 1);
                    queue.add(next);
                }
            }
        }
        
        return out;
    }
}

/*
Suboptimal in 23 mins

*/