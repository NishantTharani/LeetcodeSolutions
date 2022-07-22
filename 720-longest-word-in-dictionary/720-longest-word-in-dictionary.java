class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words, new Comparator<String>(){
            public int compare(String one, String two) {
                if (one.length() != two.length()) {
                    return one.length() - two.length();
                } else {
                    return one.compareTo(two);
                }
            }
        });
        Set<String> possible = new HashSet<>();
        String out = "";
        possible.add("");
        
        for (String s : words) {
            if (possible.contains(s.substring(0, s.length() - 1))) {
                possible.add(s);
                if (s.length() > out.length())
                    out = s;
            }
        }
        
        return out;
    }
}