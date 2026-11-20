class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValid(board, row, col, ch)) {
                            board[row][col] = ch;

                            if (backtrack(board)) {
                                return true;
                            }

                            // Backtrack if placing 'ch' doesn't lead to a valid solution
                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        // All cells filled validly
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char ch) {
        int boxRowStart = (row / 3) * 3;
        int boxColStart = (col / 3) * 3;

        for (int i = 0; i < 9; i++) {
            // Check row and column
            if (board[row][i] == ch || board[i][col] == ch) {
                return false;
            }
            // Check 3x3 sub-box
            int subRow = boxRowStart + (i / 3);
            int subCol = boxColStart + (i % 3);
            if (board[subRow][subCol] == ch) {
                return false;
            }
        }

        return true;
    }
}