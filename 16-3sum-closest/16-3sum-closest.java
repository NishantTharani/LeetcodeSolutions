class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        
        for (int i = 0; i < nums.length - 2; i++) {
            
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            
            int j = i+1;
            int k = nums.length - 1;
            
            while (j < k) {
                if (j > i+1 && nums[j] == nums[j-1])
                    j++;
                else if (k < nums.length - 1 && nums[k] == nums[k+1])
                    k--;
                else {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == target)
                        return sum;
                    if (Math.abs(target - sum) < Math.abs(closest - target))
                        closest = sum;
                    if (sum < target)
                        j++;
                    else
                        k--;
                }
            }
        }
        
        return closest;
        
    }
}