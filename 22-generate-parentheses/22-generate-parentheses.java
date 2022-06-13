class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> out = new ArrayList<>();
        Queue<StringBuilder> queue = new LinkedList<>();
        queue.add(new StringBuilder(""));
        
        for (int i = 0; i < n; i++) {
            int sz = queue.size();
            
            for (int j = 0; j < sz; j++) {
                StringBuilder sb = queue.poll();
                
                StringBuilder next = new StringBuilder(sb.toString());
                next.insert(0, "()");
                if (next.length() == n*2) {
                    out.add(next.toString());
                } else {
                    queue.add(next);   
                }
                
                for (int k = 0; k < sb.length(); k++) {
                    if (sb.charAt(k) == '(') {
                        next = new StringBuilder(sb.toString());
                        next.insert(k+1, "()");
                        if (next.length() == n*2) {
                            out.add(next.toString());
                        } else {
                            queue.add(next);    
                        }
                        
                    } else {
                        break;
                    }
                }
            }
        }
        
        return out;
        
    }
}