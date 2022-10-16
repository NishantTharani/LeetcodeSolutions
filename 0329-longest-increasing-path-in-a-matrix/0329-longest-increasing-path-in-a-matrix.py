class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        vals = {}  # (row,col) => value
        longest_path = float('-inf');
        
        def dfs(grid, row, col, vals):
            nonlocal longest_path
            key = (row, col)
            if key in vals:
                return vals[key]
            
            n = len(grid)
            m = len(grid[0])
            out = 1
            for nr, nc in [(row+1,col), (row-1,col), (row,col-1), (row,col+1)]:
                if nr >= 0 and nr < n and nc >= 0 and nc < m and grid[nr][nc] > grid[row][col]:
                    out = max(out, dfs(grid, nr, nc, vals) + 1)
            
            vals[key] = out
            longest_path = max(longest_path, out)
            return out
        
        n = len(matrix)
        m = len(matrix[0])
        for row in range(n):
            for col in range(m):
                dfs(matrix, row, col, vals)
        
        return longest_path