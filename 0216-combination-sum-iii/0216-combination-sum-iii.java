import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, new ArrayList<>(), n, k, result);
        return result;
    }

    private void backtrack(int start, List<Integer> current, int target, int k, List<List<Integer>> result) {
        // Success Base Case
        if (current.size() == k && target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Pruning / Failure Base Case
        if (current.size() > k || target < 0) {
            return;
        }

        // Numbers 1 through 9
        for (int i = start; i <= 9; i++) {
            current.add(i);
            backtrack(i + 1, current, target - i, k, result); // i + 1 ensures unique choices
            current.remove(current.size() - 1); // Backtrack
        }
    }
}