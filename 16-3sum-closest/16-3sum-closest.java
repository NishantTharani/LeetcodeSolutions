class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        int guess;
        
        int x, y, z;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i+1;
            int k = nums.length - 1;
            
            while (j < k) {
                guess = nums[i] + nums[j] + nums[k];
                
                if (Math.abs(guess - target) < Math.abs(closest - target)) {
                    closest = guess;
                }
                
                if (guess == target) {
                    return guess;
                } else if (guess < target) {
                    j++;
                } else if (guess > target) {
                    k--;
                }
            }
        }
        
        return closest;
    }
}