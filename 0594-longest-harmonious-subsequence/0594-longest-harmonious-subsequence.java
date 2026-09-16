import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxLength = 0;

        // 1. Frequency Map එක සකස් කිරීම
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // 2. x සහ x + 1 සඳහා Maximum Subsequence Length එක සෙවීම
        for (int key : countMap.keySet()) {
            if (countMap.containsKey(key + 1)) {
                int currentLength = countMap.get(key) + countMap.get(key + 1);
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }
}