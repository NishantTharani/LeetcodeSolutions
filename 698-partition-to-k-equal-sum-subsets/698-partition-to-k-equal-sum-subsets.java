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
        
        // Brute force solution?
        int[] buckets = new int[k];
        return rec(nums, sum, 0, buckets);
        
    }
    
    private boolean rec(int[] nums, int sum, int idx, int[] buckets) {
        if (idx == nums.length)
            return true;
        
        boolean out = false;
        Set<Integer> tried = new HashSet<>();
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] + nums[idx] <= sum && !tried.contains(buckets[i])) {
                tried.add(buckets[i]);
                buckets[i] += nums[idx];
                out = out || rec(nums, sum, idx+1, buckets);
                buckets[i] -= nums[idx];
            }
        }
        
        return out;
    }
}