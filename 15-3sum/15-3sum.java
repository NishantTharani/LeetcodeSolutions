class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> out = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            
            int j = i+1;
            int k = nums.length - 1;
            
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    out.add(tmp);
                }
                
                if (nums[i] + nums[j] + nums[k] <= 0) {
                    j++;
                    while (j < nums.length && nums[j] == nums[j-1])
                        j++;
                } else {
                    k--;
                    while (k >= 0 && nums[k] == nums[k+1])
                        k--;
                }
            }
        }
        
        return out;
    }
}