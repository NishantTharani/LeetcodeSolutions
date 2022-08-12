class Solution {
    public int majorityElement(int[] nums) {
        int out = nums[0];
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > max) {
                max = map.get(num);
                out = num;
            }
        }
        
        return out;
    }
}