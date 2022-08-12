class Solution {
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        return rec(nums, target, map);
        
    }
    
    private int rec(int[] nums, int target, Map<Integer, Integer> map) {
        if (map.containsKey(target))
            return map.get(target);
        
        int val = 0;
        for (int num : nums) {
            if (num < target) {
                val += rec(nums, target - num, map);
            } else if (num == target) {
                val++;
            }
        }
        
        map.put(target, val);
        return val;
    }
}