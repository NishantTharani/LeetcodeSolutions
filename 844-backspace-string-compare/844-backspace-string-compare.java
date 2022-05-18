class Solution {
    public boolean backspaceCompare(String s, String t) {
        int a = s.length() - 1;
        int b = t.length() - 1;
        int count;
        
        while (a >= 0 && b >= 0) {
            a = doBackspace(s, a);
            
            b = doBackspace(t, b);
            
            if (a >= 0 && b >= 0 && s.charAt(a--) != t.charAt(b--))
                return false;
        
        }
        
        if (doBackspace(s, a) >= 0)
            return false;
        
        if (doBackspace(t, b) >= 0)
            return false;
        
        return true;
    }
    
    private int doBackspace(String s, int a) {
        int count = 0;
        while (a >= 0 && (count > 0 || s.charAt(a) == '#')) {
            if (s.charAt(a) == '#') {
                count++;
                a--;
            } else {
                a--;
                count--;
            }
        }
        
        return a;
    }
}