class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<Integer>());
        
        for (int num : nums) {
            int n = subsets.size();
            for (int i = 0; i < n; i++) {
                List<Integer> base = subsets.get(i);
                List<Integer> next = new ArrayList<Integer>(base);
                next.add(num);
                subsets.add(next);
            }
        }
        
        return subsets;
    }
}