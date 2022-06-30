class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        char maxChar = '.';
        
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            if (map.get(s.charAt(i)) > (s.length() + 1)/2) {
                return "";
            }
            if (map.get(s.charAt(i)) > max) {
                max = map.get(s.charAt(i));
                maxChar = s.charAt(i);
            }
        }
        
        char[] out = new char[s.length()];
        int idx = 0;
        
        for (int i = 0; i < map.get(maxChar); i++) {
            out[idx] = maxChar;
            idx += 2;

            if (idx >= s.length()) {
                idx = 1;
            }
        }
        
        map.remove(maxChar);
               

        
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            for (int i = 0; i < e.getValue(); i++) {
                out[idx] = e.getKey();
                idx += 2;
                
                if (idx >= s.length()) {
                    idx = 1;
                }
            }
        }

        return new String(out);
        
    }
}

