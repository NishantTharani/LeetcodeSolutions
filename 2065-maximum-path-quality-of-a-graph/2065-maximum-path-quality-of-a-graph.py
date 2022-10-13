class Solution:
    def maximalPathQuality(self, values: List[int], edges: List[List[int]], maxTime: int) -> int:
        graph = collections.defaultdict(list)
        for edge in edges:
            graph[edge[0]].append((edge[1], edge[2]))
            graph[edge[1]].append((edge[0], edge[2]))
        
        visited = collections.defaultdict(int)
        max_quality = 0
        
        def rec(graph, values, visited, maxTime, curr, val):
            nonlocal max_quality
            if curr == 0:
                max_quality = max(max_quality, val)
            
            for next_node, next_time in graph[curr]:
                if next_time <= maxTime:
                    next_val = val if visited[next_node] > 0 else val + values[next_node]
                    visited[next_node] += 1
                    rec(graph, values, visited, maxTime - next_time, next_node, next_val)
                    visited[next_node] -= 1
        
        visited[0] += 1
        rec(graph, values, visited, maxTime, 0, values[0])
        return max_quality
        
        
    

"""
Brainstorm:

Return cost for each node: (minimum) cost of getting back to start node from there
So in a simulated solution, cannot visit a node if its return cost is > the remaining time after getting there

How to use the 'max 4 edges per node' fact?

Brute force: 
    for each node, 
        try visiting each of the (max 4) nodes connected to it, that we have the time to reach
        Remember to update them as visited
        update the nonlocal max_value whenever we find ourselves at start node

Can DP this?
    
"""