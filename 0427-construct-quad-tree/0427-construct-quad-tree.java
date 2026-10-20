class Solution {
    public Node construct(int[][] grid) {
        return helper(grid, 0, 0, grid.length);
    }

    private Node helper(int[][] grid, int r, int c, int size) {
        // Check if all elements in the current grid are the same
        if (isAllSame(grid, r, c, size)) {
            return new Node(grid[r][c] == 1, true);
        }

        // If not the same, divide into 4 sub-grids
        int half = size / 2;
        Node node = new Node(true, false);

        node.topLeft = helper(grid, r, c, half);
        node.topRight = helper(grid, r, c + half, half);
        node.bottomLeft = helper(grid, r + half, c, half);
        node.bottomRight = helper(grid, r + half, c + half, half);

        return node;
    }

    private boolean isAllSame(int[][] grid, int r, int c, int size) {
        int val = grid[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (grid[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }
}