import java.util.HashMap;
import java.util.Map;

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> sumMap = new HashMap<>();

        // Store frequencies of sums of pairs from nums1 and nums2
        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;

        // Check pairs from nums3 and nums4 and find the complement in the map
        for (int c : nums3) {
            for (int d : nums4) {
                int target = -(c + d);
                if (sumMap.containsKey(target)) {
                    count += sumMap.get(target);
                }
            }
        }

        return count;
    }
}