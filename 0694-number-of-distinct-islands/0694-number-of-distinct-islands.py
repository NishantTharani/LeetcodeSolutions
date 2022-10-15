class Solution:
    def numDistinctIslands(self, grid: List[List[int]]) -> int:
        islands = set()
        # For each cell, if it's a 1 then trigger DFS
        for row_idx, row in enumerate(grid):
            for col_idx, cell in enumerate(row):
                if cell == 1:
                    # Initialize DFS for this island
                    locs = set()
                    # Mark the cell as visited first
                    grid[row_idx][col_idx] = -1
                    # And add the co-ordinates to locs
                    locs.add((0,0))
                    # Start DFS
                    self.dfs(grid, row_idx, col_idx, row_idx, col_idx, locs)
                    if locs:
                        islands.add(frozenset(locs))
        
        return len(islands)
        
    
    
    def dfs(self, grid, row, col, relative_row, relative_col, locs):
        """
        locs is a dict specific to this island
            locs[row] is a [start,end] pair of the first and last column in this row for this island
        row,col must be marked as visited BEFORE this is called
        and locs must be updated BEFORE this is called
        """
        n = len(grid)
        m = len(grid[0])
        for nr, nc in [(row-1,col), (row+1,col), (row,col-1), (row,col+1)]:
            if nr >= 0 and nr < n and nc >= 0 and nc < m and grid[nr][nc] == 1:
                # Mark as visited
                grid[nr][nc] = -1
                # Update locs
                loc_row = nr - relative_row
                loc_col = nc - relative_col
                locs.add((loc_row,loc_col))
                self.dfs(grid, nr, nc, relative_row, relative_col, locs)
        
        

        
"""
To find the islands: run DFS, mutating the grid to keep track of visited cells
In the process of DFS: keep track of the first and last cell in each row of the island?
"""