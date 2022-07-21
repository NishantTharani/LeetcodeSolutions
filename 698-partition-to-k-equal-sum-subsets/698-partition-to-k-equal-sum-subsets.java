class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // Solved brute force in 19 mins
        // First check what the sum of each subset needs to be
        int sum = 0;
        for (int num : nums)
            sum += num;
        
        if (sum % k != 0)
            return false;
        
        sum /= k;
        
        // Memoized solution:
        int taken = 0;
        Map<Integer,Boolean> memory = new HashMap<>();
        
        return rec(nums, sum, 0, k, taken, memory);
    }
    
    private boolean rec(int[] nums, int sum, int currentSum, int count, int taken, Map<Integer,Boolean> memory) {
        
        if (memory.containsKey(taken))
            return memory.get(taken);
        
        if (count == 1) {
            memory.put(taken, true);
            return true;
        }
        
        if (currentSum > sum) {
            return false;
        }
        
        if (currentSum == sum) {
            boolean out = rec(nums, sum, 0, count-1, taken, memory);
            memory.put(taken, out);
            return out;
        }
        
        for (int j = 0; j < nums.length; j++) {
            if (((taken >> j) & 1) != 1) {
                taken = taken | (1 << j);
                
                if (rec(nums, sum, currentSum+nums[j], count, taken, memory)) {
                    memory.put(taken, true);
                    return true;
                }
                
                taken = taken ^ (1 << j);
            }
        }
        
        memory.put(taken, false);
        return false;
    }
}