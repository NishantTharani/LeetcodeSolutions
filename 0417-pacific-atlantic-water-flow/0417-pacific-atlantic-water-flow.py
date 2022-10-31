class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        # Helper function to get all cells that are uphill from a given cell
        def get_uphill_from(row, col, heights):
            n = len(heights)
            m = len(heights[0])
            out = []
            for nr, nc in ((row+1,col), (row-1,col), (row,col+1), (row,col-1)):
                if nr < n and nr >= 0 and nc < m and nc >= 0 and heights[nr][nc] >= heights[row][col]:
                    out.append((nr, nc))
            return out
            
        # Run BFS twice: once starting from all cells next to each ocean
        n = len(heights)
        m = len(heights[0])
        can_reach_atlantic = [[False for _ in range(m)] for _ in range(n)]
        can_reach_pacific = [[False for _ in range(m)] for _ in range(n)]
        
        def bfs(visited, queue, reach_array):
            while len(queue) > 0:
                row, col = queue.popleft()
                reach_array[row][col] = True
                for nr, nc in get_uphill_from(row, col, heights):
                    if (nr, nc) not in visited:
                        visited.add((nr,nc))
                        queue.append((nr,nc))
        
        visited = set()
        queue = collections.deque()
        for i in range(n):
            queue.append((i, m-1))
            visited.add((i, m-1))
        for j in range(m):
            queue.append((n-1, j))
            visited.add((n-1, j))
        bfs(visited, queue, can_reach_atlantic)
        
        visited = set()
        queue = collections.deque()
        for i in range(n):
            queue.append((i, 0))
            visited.add((i, 0))
        for j in range(m):
            queue.append((0, j))
            visited.add((0, j))
        bfs(visited, queue, can_reach_pacific)
        
        # Return the conjunction of the two 2D grids
        out = []
        for i in range(n):
            for j in range(m):
                if can_reach_atlantic[i][j] and can_reach_pacific[i][j]:
                    out.append((i,j))
        
        return out
        
        