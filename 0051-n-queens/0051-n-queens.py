class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        out_queens = []
        
        def rec(queens, rows, cols, sums, diffs, n, i, j):
            nonlocal out_queens
            
            if i >= n:
                return
            
            new_j = j + 1
            new_i = i
            if new_j == n:
                new_j = 0
                new_i += 1
            
            # is i,j a valid queen position?
            row_valid = i not in rows
            col_valid = j not in cols
            sum_valid = i+j not in sums
            diff_valid = j-i not in diffs
            if row_valid and col_valid and sum_valid and diff_valid:
                queens.append((i,j))
                if len(queens) == n:
                    out_queens.append(list(queens))
                rows.add(i)
                cols.add(j)
                sums.add(i+j)
                diffs.add(j-i)
            
                rec(queens, rows, cols, sums, diffs, n, i+1, 0)
                
                queens.pop()
                rows.remove(i)
                cols.remove(j)
                sums.remove(i+j)
                diffs.remove(j-i)
            
            rec(queens, rows, cols, sums, diffs, n, new_i, new_j)
            
        rec([], set(), set(), set(), set(), n, 0, 0)
        
        # Generate output boards from out_queens
        out = []
        for queens in out_queens:
            board = [['.' for _ in range(n)] for _ in range(n)]
            for queen in queens:
                board[queen[0]][queen[1]] = 'Q'
            out.append([''.join(row) for row in board])
        
        return out

"""
Brainstorm:
    keep track of queen positions
    constraints:
        one queen per row
        one queen per column
        one queen per row+col sum (off-diagonal)
        one queen per col-row difference (on-diagonal)
"""