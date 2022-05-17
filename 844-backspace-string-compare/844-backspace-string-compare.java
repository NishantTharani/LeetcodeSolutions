class Solution {
    public boolean backspaceCompare(String s, String t) {
        return parseString(s).equals(parseString(t));
    }
    
    private String parseString(String s) {
        StringBuilder a = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (c != '#') {
                a.append(c);
            } else {
                if (a.length() > 0)
                    a.deleteCharAt(a.length() - 1);
            }
        }
        
        return a.toString();
    }
}