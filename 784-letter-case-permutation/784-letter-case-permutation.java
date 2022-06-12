class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> out = new ArrayList<>();
        Queue<String> perms = new LinkedList<>();
        perms.add("");
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int n = perms.size();
            
            for (int j = 0; j < n; j++) {
                String base = perms.poll();
                
                if (Character.isDigit(c)) {
                    String next = base + c;
                    if (next.length() == s.length()) {
                        out.add(next);
                    } else {
                        perms.add(next);
                    }
                } else {
                    String next1 = base + c;
                    String next2;
                    if (Character.isLowerCase(c)) {
                        next2 = base + Character.toUpperCase(c);
                    } else {
                        next2 = base + Character.toLowerCase(c);
                    }
                    if (next1.length() == s.length()) {
                        out.add(next1);
                        out.add(next2);
                    } else {
                        perms.add(next1);
                        perms.add(next2);
                    }
                }
            }
        }
        
        return out;
        
    }
}