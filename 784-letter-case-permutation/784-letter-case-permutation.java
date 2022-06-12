class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> out = new ArrayList<>();
        Queue<StringBuilder> perms = new LinkedList<>();
        perms.add(new StringBuilder(""));
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int n = perms.size();
            
            for (int j = 0; j < n; j++) {
                StringBuilder base = perms.poll();
                
                if (Character.isDigit(c)) {
                    base.append(c);
                    if (base.length() == s.length()) {
                        out.add(base.toString());
                    } else {
                        perms.add(base);
                    }
                } else {
                    StringBuilder copy = new StringBuilder(base.toString());
                    base.append(c);
                    if (Character.isLowerCase(c)) {
                        copy.append(Character.toUpperCase(c));
                    } else {
                        copy.append(Character.toLowerCase(c));
                    }
                    if (base.length() == s.length()) {
                        out.add(base.toString());
                        out.add(copy.toString());
                    } else {
                        perms.add(base);
                        perms.add(copy);
                    }
                }
            }
        }
        
        return out;
        
    }
}