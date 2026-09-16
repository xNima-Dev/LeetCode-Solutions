import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;

        // 1. Map list1 elements to their indices
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        // 2. Iterate list2 and check for common strings
        for (int j = 0; j < list2.length; j++) {
            if (map.containsKey(list2[j])) {
                int sum = map.get(list2[j]) + j;

                if (sum < minSum) {
                    minSum = sum;
                    result.clear();
                    result.add(list2[j]);
                } else if (sum == minSum) {
                    result.add(list2[j]);
                }
            }
        }

        return result.toArray(new String[0]);
    }
}