class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Queue<List<Integer>> queue = new LinkedList<>();
        List<List<Integer>> out = new ArrayList<>();
        out.add(new ArrayList<Integer>());
        
        for (int i = 0; i < nums.length; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(i);
            queue.add(tmp);
        }
        
        while (queue.size() > 0) {
            List<Integer> idxs = queue.poll();            
            List<Integer> vals = new ArrayList<>();
            
            for (int idx : idxs) {
                vals.add(nums[idx]);
            }
            out.add(vals);
            
            int end = idxs.get(idxs.size() - 1);
            for (int j = end + 1; j < nums.length; j++) {
                List<Integer> newIdxs = new ArrayList<>(idxs);
                newIdxs.add(j);
                queue.add(newIdxs);
            }
        }
        
        return out;
    }
}