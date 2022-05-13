class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> out = new HashSet<List<Integer>>();
        
        if (nums.length < 3)
            return new ArrayList<List<Integer>>(out);
        
        // Sort it first  
        Arrays.sort(nums);
        
        int x, y;
        
        for (int i = 0; i < nums.length; i++) {
            x = nums[i];
            Map<Integer, Integer> map = new HashMap<>();
            
            for (int j = i+1; j < nums.length; j++) {
                y = nums[j];
                
                if (map.containsKey(y)) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(x);
                    tmp.add(map.get(y));
                    tmp.add(y);
                    out.add(tmp);
                }
                
                map.put(-x-y, y);
            }
            
            
        }
        
        return new ArrayList<List<Integer>>(out);
        
    }
}