class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int tmp;
        List<Integer> out = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i+1 && nums[i] != -1) {
                tmp = nums[i];
                if (nums[tmp-1] == tmp) {
                    nums[i] = -1;
                    out.add(tmp);
                } else {
                    nums[i] = nums[tmp-1];
                    nums[tmp-1] = tmp;
                }
            }
        }
        
        return out;
    }
}