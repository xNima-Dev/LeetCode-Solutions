class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 'X') {
                    // Check if it's the top-left cell of a battleship
                    boolean hasLeft = c > 0 && board[r][c - 1] == 'X';
                    boolean hasTop = r > 0 && board[r - 1][c] == 'X';

                    // If neither left nor top is 'X', this is the start of a battleship
                    if (!hasLeft && !hasTop) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}