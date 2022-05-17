class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> out = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        
        for (int a = 0; a < nums.length - 3; a++) {
            if (a > 0 && nums[a] == nums[a-1]) {
                continue;
            }
            
            for (int b = a + 1; b < nums.length - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b-1]) {
                    continue;
                }
                
                int tmpTarget = target - nums[a] - nums[b];
                Map<Integer, Integer> map = new HashMap<>();
                
                int c = b + 1;
                int d = nums.length - 1;
                
                while (c < d) {
                    if (nums[c] + nums[d] < tmpTarget) {
                        do {
                            c++;
                        } while (c < nums.length && nums[c] == nums[c-1]);
                    } else if (nums[c] + nums[d] > tmpTarget) {
                        do {
                            d--;    
                        } while (d >= 0 && nums[d] == nums[d+1]);
                    } else {
                        List<Integer> tmpOut = new ArrayList<>();
                        tmpOut.add(nums[a]);
                        tmpOut.add(nums[b]);
                        tmpOut.add(nums[c]);
                        tmpOut.add(nums[d]);
                        out.add(tmpOut);
                        c++;
                        while (c < nums.length && nums[c] == nums[c-1])
                            c++;
                    }
                }
            }
        }
        
        return out;
    }
}