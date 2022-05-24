class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> out = new ArrayList<>();
        int tmp;
        
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i+1 && nums[i] != -1) {
                tmp = nums[i];
                if (nums[tmp-1] != tmp) {
                    nums[i] = nums[tmp-1];
                    nums[tmp-1] = tmp;
                } else {
                    nums[i] = -1;
                }
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1)
                out.add(i+1);
        }
        
        return out;
    }
}