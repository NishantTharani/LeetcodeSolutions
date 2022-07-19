class Solution {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        /*
            Find a topological order
            Return false if:
                there is >1 source at any time
                there is no topological ordering
                the output is not the same as nums
            Else return true
        */
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> incoming = new HashMap<>();
        
        for (int i = 1; i <= nums.length; i++) {
            graph.put(i, new ArrayList<>());
            incoming.put(i, 0);
        }
        
        for (List<Integer> sequence : sequences) {
            for (int i = 1; i < sequence.size(); i++) {
                int a = sequence.get(i-1);
                int b = sequence.get(i);
                graph.get(a).add(b);
                incoming.put(b, incoming.get(b) + 1);
            }
        }
        
        Queue<Integer> sources = new LinkedList<>();
        List<Integer> out = new ArrayList<>();
        
        for (int i = 1; i <= nums.length; i++) {
            if (incoming.get(i) == 0)
                sources.add(i);
        }
        
        while (!sources.isEmpty()) {
            if (sources.size() > 1)
                return false;
            int v = sources.poll();
            out.add(v);
            for (int d : graph.get(v)) {
                incoming.put(d, incoming.get(d) - 1);
                if (incoming.get(d) == 0)
                    sources.add(d);
            }
        }
        
        if (out.size() < nums.length)
            return false;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != out.get(i))
                return false;
        }
        
        return true;
    }
}