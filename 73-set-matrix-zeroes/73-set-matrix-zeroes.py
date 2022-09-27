class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        rows_to_zero = set()
        cols_to_zero = set()
        n = len(matrix)
        m = len(matrix[0])
        
        for i, row in enumerate(matrix):
            for j, cell in enumerate(row):
                if cell == 0:
                    rows_to_zero.add(i)
                    cols_to_zero.add(j)
        
        for row_idx in rows_to_zero:
            for j in range(m):
                matrix[row_idx][j] = 0
        
        for col_idx in cols_to_zero:
            for i in range(n):
                matrix[i][col_idx] = 0
        