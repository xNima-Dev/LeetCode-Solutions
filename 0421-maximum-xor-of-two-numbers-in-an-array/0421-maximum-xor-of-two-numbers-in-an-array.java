import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findMaximumXOR(int[] nums) {
        int maxResult = 0;
        int mask = 0;

        // Iterate from the Most Significant Bit (30th bit) down to 0
        for (int i = 30; i >= 0; i--) {
            mask |= (1 << i);
            Set<Integer> prefixes = new HashSet<>();

            for (int num : nums) {
                prefixes.add(num & mask);
            }

            // Assume the i-th bit can be 1 in the maximum result
            int greedy = maxResult | (1 << i);
            boolean found = false;

            // Check if there exist two prefixes such that prefix1 ^ prefix2 == greedy
            for (int prefix : prefixes) {
                if (prefixes.contains(prefix ^ greedy)) {
                    found = true;
                    break;
                }
            }

            if (found) {
                maxResult = greedy;
            }
        }

        return maxResult;
    }
}