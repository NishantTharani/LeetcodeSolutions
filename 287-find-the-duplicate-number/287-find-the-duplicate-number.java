class Solution {
    public int findDuplicate(int[] nums) {
        // Find a location in the cycle that we know exists
        int slow = nums[0];
        int fast = nums[0];
        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        // Now find the length of the cycle
        int len = 0;
        do {
            slow = nums[slow];
            len++;
        } while (slow != fast);
        
        // Now find the start of the cycle - this will actually be the duplicated number
        slow = nums[0];
        fast = nums[0];
        for (int i = 0; i < len; i++) {
            slow = nums[slow];
        }
        
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
        
    }
}