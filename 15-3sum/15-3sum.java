class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> out = new ArrayList<List<Integer>>();
        
        if (nums.length < 3)
            return out;
        
        // Sort it first  
        Arrays.sort(nums);
        
        int x, y, z;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0)
                break;
            
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            
            x = nums[i];
            
            int start = i+1;
            int end = nums.length - 1;
            
            while (start < end) {
                y = nums[start];
                z = nums[end];
                if (start > i+1 && y == nums[start-1]) {
                    start++;
                    continue;
                }
                
                if (end < nums.length - 1 && z == nums[end+1]) {
                    end--;
                    continue;
                }
                
                if (x + y + z == 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(x);
                    tmp.add(y);
                    tmp.add(z);
                    out.add(tmp);
                    start++;
                } else if (x + y + z < 0) {
                    start++;
                } else {
                    end--;
                }
            }
            
        }
        
        return out;
        
    }
}