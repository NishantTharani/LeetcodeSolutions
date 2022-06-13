class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> out = new ArrayList<>();
        recAbb("", word, out);
        return out;
    }
    
    private void recAbb(String prefix, String word, List<String> out) {
        if (word.length() == 0) {
            out.add(prefix);
            return;
        }
        
        recAbb(prefix + word.charAt(0), word.substring(1), out);
        
        for (int i = 1; i < word.length(); i++) {
            recAbb(prefix + i + word.charAt(i), word.substring(i+1), out);
        }
        
        out.add(prefix + word.length());
    }
}