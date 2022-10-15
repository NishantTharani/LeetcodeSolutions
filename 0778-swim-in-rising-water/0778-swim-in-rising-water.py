class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        h = []
        n = len(grid)
        m = len(grid[0])
        target = grid[n-1][m-1]
        heapq.heappush(h, (grid[0][0], 0, 0))
        out = 0
        visited = set()
        visited.add(grid[0][0])
        
        while True:
            curr, row, col = heapq.heappop(h)
            out = max(out, curr)
            
            if curr == target:
                return out
            
            for nr, nc in ((row-1,col), (row+1,col), (row,col-1), (row,col+1)):
                if nr >= 0 and nr < n and nc >= 0 and nc < m and grid[nr][nc] not in visited:
                    heapq.heappush(h, (grid[nr][nc], nr, nc))
                    visited.add(grid[nr][nc])
            