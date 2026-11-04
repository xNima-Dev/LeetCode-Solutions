import java.util.Arrays;
import java.util.Collections;

class Solution {
    public boolean makesquare(int[] matchsticks) {
        long sum = 0;
        for (int stick : matchsticks) {
            sum += stick;
        }
        if (sum % 4 != 0) return false;
        long target = sum / 4;

        // Sort in descending order to optimize backtracking
        Integer[] sticks = Arrays.stream(matchsticks).boxed().toArray(Integer[]::new);
        Arrays.sort(sticks, Collections.reverseOrder());

        if (sticks[0] > target) return false;

        int[] sides = new int[4];
        return backtrack(0, sticks, target, sides);
    }

    private boolean backtrack(int index, Integer[] sticks, long target, int[] sides) {
        if (index == sticks.length) {
            return sides[0] == target && sides[1] == target && sides[2] == target && sides[3] == target;
        }

        int len = sticks[index];
        for (int i = 0; i < 4; i++) {
            if (sides[i] + len <= target) {
                sides[i] += len;
                if (backtrack(index + 1, sticks, target, sides)) return true;
                sides[i] -= len;
            }
            if (sides[i] == 0) break; // Optimization
        }

        return false;
    }
}