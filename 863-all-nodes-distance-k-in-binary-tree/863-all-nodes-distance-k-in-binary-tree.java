/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        graph.put(root.val, new ArrayList<>());
        
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.left != null) {
                stack.push(curr.left);
                addEdge(graph, curr.val, curr.left.val);
                addEdge(graph, curr.left.val, curr.val);
            }
            if (curr.right != null) {
                stack.push(curr.right);
                addEdge(graph, curr.val, curr.right.val);
                addEdge(graph, curr.right.val, curr.val);
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(target.val);
        visited.add(target.val);
        int level = 0;
        while (level < k) {
            // BFS the next level
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int curr = queue.poll();
                for (int next : graph.get(curr)) {
                    if (!visited.contains(next)) {
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }
            level++;
        }
        
        return new ArrayList<Integer>(queue);
    }
    
    private void addEdge(Map<Integer, List<Integer>> graph, Integer from, Integer to) {
        if (!graph.containsKey(from))
            graph.put(from, new ArrayList<Integer>());
        
        graph.get(from).add(to);
    }
}