import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;

        Map<Long, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        int totalCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];

                int countAtJ = dp[j].getOrDefault(diff, 0);
                int countAtI = dp[i].getOrDefault(diff, 0);

                // Add existing sequences ending at j extended by nums[i] to total count
                totalCount += countAtJ;

                // Update dp[i] for this difference
                dp[i].put(diff, countAtI + countAtJ + 1);
            }
        }

        return totalCount;
    }
}