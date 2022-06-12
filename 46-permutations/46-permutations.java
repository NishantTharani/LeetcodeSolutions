class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        Queue<List<Integer>> perms = new LinkedList<>();
        perms.add(new ArrayList<Integer>());
        
        for (int num : nums) {
            int n = perms.size();
            
            for (int i = 0; i < n; i++) {
                List<Integer> perm = perms.poll();
                
                for (int j = 0; j < perm.size() + 1; j++) {
                    ArrayList<Integer> next = new ArrayList<>(perm);
                    next.add(j, num);
                    
                    if (next.size() == nums.length) {
                        out.add(next);
                    } else {
                        perms.add(next);        
                    }
                
                }
            }
        }
        
        return out;
        
    }
}