class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)
        m = len(matrix[0])
        
        for i in range(n):
            for j in range(m):
                if matrix[i][j] == 0:
                    for j_next in range(m):
                        matrix[i][j_next] = '#' if matrix[i][j_next] != 0 else 0
                    break
        
        for j in range(m):
            for i in range(n):
                if matrix[i][j] == 0:
                    for i_next in range(n):
                        matrix[i_next][j] = '#' if matrix[i_next][j] != 0 else 0
                    break
        
        for i in range(n):
            for j in range(m):
                if matrix[i][j] == '#':
                    matrix[i][j] = 0
        