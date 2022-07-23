class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length();
        int j = t.length();
        
        while (i >= 0 || j >= 0) {
            int toDel = 1;
            while (toDel > 0) {
                i--;
                toDel--;
                if (i >= 0 && s.charAt(i) == '#')
                    toDel += 2;
            }
            
            toDel = 1;
            while (toDel > 0) {
                j--;
                toDel--;
                if (j >= 0 && t.charAt(j) == '#')
                    toDel += 2;
            }

            
            char a = i < 0 ? '1' : s.charAt(i);
            char b = j < 0 ? '1' : t.charAt(j);
            if (a != b)
                return false;
        }
        
        return true;
    }
}