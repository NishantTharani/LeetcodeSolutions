class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        if len(edges) != n-1:
            return False
        
        visited = [False for _ in range(n)]
        graph = collections.defaultdict(list)
        for edge in edges:
            graph[edge[0]].append(edge[1])
            graph[edge[1]].append(edge[0])
        
        queue = collections.deque()
        queue.append(0)
        visited[0] = True
        
        while len(queue) > 0:
            curr = queue.popleft()
            for next_node in graph[curr]:
                if not visited[next_node]:
                    visited[next_node] = True
                    queue.append(next_node)
        
        for v in visited:
            if not v:
                return False
        
        return True