class NumMatrix {
    private int[][] dp;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Initialize DP array with size (rows + 1) x (cols + 1)
        dp = new int[rows + 1][cols + 1];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dp[r + 1][c + 1] = matrix[r][c] 
                                 + dp[r][c + 1] 
                                 + dp[r + 1][c] 
                                 - dp[r][c];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] 
             - dp[row1][col2 + 1] 
             - dp[row2 + 1][col1] 
             + dp[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */