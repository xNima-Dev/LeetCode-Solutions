import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, target, candidates, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(
            int startIndex,
            int remaining,
            int[] candidates,
            List<Integer> current,
            List<List<Integer>> result
    ) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            // Skip duplicate elements at the same recursion level
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }

            int candidate = candidates[i];
            if (candidate > remaining) {
                break;
            }

            current.add(candidate);
            // Move to 'i + 1' because each element can be used only once
            backtrack(i + 1, remaining - candidate, candidates, current, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }
}