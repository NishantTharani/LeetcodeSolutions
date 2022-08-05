class Solution {
    boolean solved = false;
    
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char cell = board[i][j];
                if (cell == '.') {
                    for (int candidate = 1; candidate <= 9; candidate++) {
                        if (!this.solved) {
                            char candidateChar = (char) ('0' + candidate);
                            board[i][j] = candidateChar;
                            if (isValidBoard(board))
                                solveSudoku(board);
                        }
                    }
                    
                    if (!this.solved) {
                        board[i][j] = '.';
                        return;
                    }
                }
            }
        }
        
        this.solved = true;
    }
    
    
    
    private boolean isValidBoard(char[][] board) {
        // Check rows
        for (char[] row : board) {
            boolean[] visited = new boolean[9];
            for (char c : row) {
                if (c == '.')
                    continue;
                if (visited[c - '1'])
                    return false;
                visited[c - '1'] = true;
            }
        }
        
        // Check columns
        for (int j = 0; j < 9; j++) {
            boolean[] visited = new boolean[9];
            for (int i = 0; i < 9; i++) {
                char c = board[i][j];
                if (c == '.')
                    continue;
                if (visited[c - '1'])
                    return false;
                visited[c - '1'] = true;
            }
        }
        
        // Check miniboxes
        for (int left = 0; left < 9; left += 3) {
            for (int top = 0; top < 9; top += 3) {
                boolean[] visited = new boolean[9];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int row = top + i;
                        int col = left + j;
                        char c = board[row][col];
                        if (c == '.')
                            continue;
                        if (visited[c - '1'])
                            return false;
                        visited[c - '1'] = true;
                    }
                }
            }
        }
        
        return true;
    }
    
}



