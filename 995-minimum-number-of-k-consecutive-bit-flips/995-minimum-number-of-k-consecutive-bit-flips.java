class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int flips = 0;
        boolean flipped = false;
        int zero = 0;
        Queue<Integer> flipPoints = new LinkedList<>();
        
        for (int i = 0; i < nums.length - k + 1; i++) {
            if (!flipPoints.isEmpty() && i == flipPoints.peek()) {
                flipPoints.poll();
                flipped = !flipped;
            }
            
            zero = flipped ? 1 : 0;
            if (nums[i] == zero) {
                flips++;
                flipped = !flipped;
                flipPoints.add(i+k);
            }
        }
        
        
        for (int i = nums.length - k + 1; i < nums.length; i++) {
            if (!flipPoints.isEmpty() && i == flipPoints.peek()) {
                flipPoints.poll();
                flipped = !flipped;
            }
            zero = flipped ? 1 : 0;
            if (nums[i] == zero)
                return -1;
        }
        
        return flips;
    }
    
}


/*
Some features of this problem:
    note that 'k' is fixed
    order of a given set of bit flips doesn't matter
    brute force: is for every possible position, try a bit flip or not, then move on. 2^N * N
    better is to note that we can never leave a 0 behind, so do it in one pass. O(N * K)    
*/