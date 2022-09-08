class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        # Create the graph representation
        graph = {}
        for eq, val in zip(equations, values):
            a, b = eq
            if a not in graph:
                graph[a] = []
            if b not in graph:
                graph[b] = []
            graph[a].append((b, val))
            graph[b].append((a, 1/val))
        
        # Run DFS for each query to find the path
        out = []
        for query in queries:
            parents = {}
            parents[query[0]] = None
            visited = set()
            stack = []
            if query[0] in graph:
                stack.append(query[0])
            success = False
            target = query[1]
            
            while len(stack) > 0:
                curr = stack.pop()
                if curr == target:
                    success = True
                    break
                visited.add(curr)
                if curr in graph:
                    for next_node in graph[curr]:
                        if next_node[0] not in visited:
                            parents[next_node[0]] = (curr, next_node[1])
                            stack.append(next_node[0])
            
            if not success:
                out.append(-1)
            else:
                val = 1.0
                curr = target
                while parents[curr] is not None:
                    val *= parents[curr][1]
                    curr = parents[curr][0]
                out.append(val)
        
        return out
            
    

        