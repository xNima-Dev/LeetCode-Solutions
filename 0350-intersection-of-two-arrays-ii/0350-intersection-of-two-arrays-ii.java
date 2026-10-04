import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Memory Optimization: Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums1) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        List<Integer> resultList = new ArrayList<>();
        for (int num : nums2) {
            if (counts.getOrDefault(num, 0) > 0) {
                resultList.add(num);
                counts.put(num, counts.get(num) - 1);
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}