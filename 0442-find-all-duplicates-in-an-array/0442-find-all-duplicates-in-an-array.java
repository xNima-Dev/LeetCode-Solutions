import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            // If the value at the mapped index is negative, it's a duplicate
            if (nums[index] < 0) {
                result.add(index + 1);
            } else {
                // Mark as visited by negating the value
                nums[index] = -nums[index];
            }
        }

        return result;
    }
}