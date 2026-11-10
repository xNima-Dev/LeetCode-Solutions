import java.util.Arrays;

class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return solve(nums, 0, n - 1, memo) >= 0;
    }

    private int solve(int[] nums, int left, int right, int[][] memo) {
        if (left == right) {
            return nums[left];
        }
        if (memo[left][right] != -1) {
            return memo[left][right];
        }

        int chooseLeft = nums[left] - solve(nums, left + 1, right, memo);
        int chooseRight = nums[right] - solve(nums, left, right - 1, memo);

        memo[left][right] = Math.max(chooseLeft, chooseRight);
        return memo[left][right];
    }
}