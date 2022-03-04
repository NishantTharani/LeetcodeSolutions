class Solution {
    public int totalFruit(int[] fruits) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int types = 0;
        
        for (int end = 0; end < fruits.length; end++) {
            map.put(fruits[end], map.getOrDefault(fruits[end], 0) + 1);
            
            if (map.get(fruits[end]) == 1)
                types++;
            
            while (types > 2) {
                map.put(fruits[start], map.get(fruits[start]) - 1);
                if (map.get(fruits[start]) == 0)
                    types--;
                start++;
            }
            
            max = Math.max(max, end + 1 - start);
        }
        
        return max;
    }
}