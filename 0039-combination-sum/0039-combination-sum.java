import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            int candidate = candidates[i];

            if (candidate > remaining) {
                break;
            }

            current.add(candidate);
            // Pass 'i' to allow unlimited reuse of the current candidate
            backtrack(i, remaining - candidate, candidates, current, result);
            current.remove(current.size() - 1);
        }
    }
}