import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        Queue<int[]> queuePacific = new LinkedList<>();
        Queue<int[]> queueAtlantic = new LinkedList<>();

        // Initialize borders
        for (int r = 0; r < m; r++) {
            queuePacific.offer(new int[]{r, 0});
            pacific[r][0] = true;

            queueAtlantic.offer(new int[]{r, n - 1});
            atlantic[r][n - 1] = true;
        }

        for (int c = 0; c < n; c++) {
            queuePacific.offer(new int[]{0, c});
            pacific[0][c] = true;

            queueAtlantic.offer(new int[]{m - 1, c});
            atlantic[m - 1][c] = true;
        }

        bfs(heights, queuePacific, pacific, m, n);
        bfs(heights, queueAtlantic, atlantic, m, n);

        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(r);
                    cell.add(c);
                    result.add(cell);
                }
            }
        }

        return result;
    }

    private void bfs(int[][] heights, Queue<int[]> queue, boolean[][] visited, int m, int n) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                    if (heights[nr][nc] >= heights[r][c]) {
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
    }
}