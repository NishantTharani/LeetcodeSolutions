class Solution:
    def getFood(self, grid: List[List[str]]) -> int:
        start = None
        n = len(grid)
        m = len(grid[0])
        
        # Locate current cell
        for row_idx, row in enumerate(grid):
            for col_idx, cell in enumerate(row):
                if cell == '*':
                    start = (row_idx, col_idx)
                    break
        
        # Run BFS until I reach a food cell
        queue = collections.deque()
        queue.append((start, 0))
        visited = set()
        visited.add(start)
        
        while len(queue) > 0:
            (row, col), dist = queue.popleft()
            for nr, nc in ((row+1, col), (row-1, col), (row, col+1), (row, col-1)):
                if nr >= 0 and nr < n and nc >= 0 and nc < m and grid[nr][nc] != 'X' and (nr, nc) not in visited:
                    if grid[nr][nc] == '#':
                        return dist + 1
                    queue.append(((nr, nc), dist + 1))
                    visited.add((nr, nc))
        
        # Return -1 if no food cell was reached
        return -1