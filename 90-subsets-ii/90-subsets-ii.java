class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<Integer>());
        
        int j;
        int n = subsets.size();
        
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                j = n;
            } else {
                j = 0;
            }
            
            n = subsets.size();
            while (j < n) {
                List<Integer> base = subsets.get(j);
                List<Integer> next = new ArrayList<>(base);
                next.add(nums[i]);
                subsets.add(next);
                j++;
            }
        }
        
        return subsets;
    }
}