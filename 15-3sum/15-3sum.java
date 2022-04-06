class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> outSet = new HashSet<List<Integer>>();
        
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            Map<Integer, Integer> map = new HashMap<>();
            
            for (int j = i+1; j < nums.length; j++) {
                if (map.containsKey(nums[j])) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[map.get(nums[j])]);
                    tmp.add(nums[j]);
                    Collections.sort(tmp);
                    outSet.add(tmp);
                }
                map.put(0 - target - nums[j], j);
            }
        }
        
        List<List<Integer>> out = new ArrayList<>(outSet);
        return out;
    }
}