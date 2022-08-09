class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] palindromes = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            int left = i;
            int right = i;
            
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                palindromes[left][right] = true;
                left--;
                right++;
            }
            
            left = i;
            right = i+1;
            
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                palindromes[left][right] = true;
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
                for (int i = idx; i < n; i++) {
                    if (palindromes[idx][i]) {
                        List<Integer> next = new ArrayList<>(curr);
                        next.add(i+1);
                        queue.add(next);
                    }
                }
            }
        }
        
        return out;
    }
}

/*
Suboptimal in 23 mins

*/