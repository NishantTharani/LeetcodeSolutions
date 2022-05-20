class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int slow;
        int fast;
        int prev;
        
        for (int i = 0; i < nums.length; i++) {
            slow = i;
            fast = i;
            
            while (true) {
                // Update slow
                slow = addToIdx(slow, nums.length, nums[slow]);
                
                // Update fast and check for fail conditions
                prev = fast;
                fast = addToIdx(fast, nums.length, nums[fast]);
                if (fast == prev)
                    break;
                if (nums[prev] * nums[fast] < 0)
                    break;
                prev = fast;
                fast = addToIdx(fast, nums.length, nums[fast]);
                if (fast == prev)
                    break;
                if (nums[prev] * nums[fast] < 0)
                    break;
                
                // If the pointers have met, we have a cycle
                if (slow == fast)
                    return true;
            }
        }
        
        return false;
    }
    
    private int addToIdx(int idx, int len, int add) {
        idx = (idx + add) % len;
        if (idx < 0)
            idx += len;
        return idx;
    }
}