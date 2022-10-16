class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        graph = collections.defaultdict(list)  # (row,col) -> list(row,col)
        outgoing = {}  # (row,col) -> number of cells that we can move to
        n = len(matrix)
        m = len(matrix[0])
        
        # Build up graph
        for row_idx, row in enumerate(matrix):
            for col_idx, cell in enumerate(row):
                outgoing[(row_idx, col_idx)] = 0
                for nr, nc in [(row_idx+1,col_idx), (row_idx-1,col_idx), (row_idx,col_idx-1), (row_idx,col_idx+1)]:
                    if nr >= 0 and nr < n and nc >= 0 and nc < m and matrix[nr][nc] > cell:
                        outgoing[(row_idx, col_idx)] += 1
                        graph[(nr, nc)].append((row_idx, col_idx))
        
        print(graph)
        print(outgoing)
        
        # Work through in reverse order
        queue = collections.deque()
        for row, col in outgoing:
            if outgoing[(row, col)] == 0:
                queue.append((row, col))
        
        vals = [[None for _ in range(m)] for _ in range(n)]
        max_value = float('-inf')
        
        while len(queue) > 0:
            row, col = queue.popleft()
            print("Now at: " + str(row) + ',' + str(col))
            
            old_val = 1
            val = old_val
            for nr, nc in [(row+1,col), (row-1,col), (row,col+1), (row,col-1)]:
                if nr >= 0 and nr < n and nc >= 0 and nc < m and matrix[nr][nc] > matrix[row][col]:
                    val = max(val, old_val + vals[nr][nc])
            
            print("Value:", val)
            vals[row][col] = val
            max_value = max(max_value, val)
            
            for nr, nc in graph[(row,col)]:
                outgoing[(nr, nc)] -= 1
                if outgoing[(nr, nc)] == 0:
                    queue.append((nr, nc))
        
        return max_value
        
        