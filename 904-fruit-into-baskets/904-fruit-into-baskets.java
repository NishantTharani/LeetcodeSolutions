class Solution {
    public int totalFruit(int[] fruits) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int end = 0;
        int types = 0;
        
        for (int start = 0; start < fruits.length; start++) {
            while (types <= 2 && end < fruits.length) {
                map.put(fruits[end], map.getOrDefault(fruits[end], 0) + 1);
                if (map.get(fruits[end]) == 1)
                    types++;
                end++;
                if (types <= 2)
                    max = Math.max(max, end - start);
            }
            
            map.put(fruits[start], map.get(fruits[start]) - 1);
            if (map.get(fruits[start]) == 0)
                types--;
        }
        
        return max;
    }
}