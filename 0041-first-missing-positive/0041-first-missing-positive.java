class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Place each number x in [1, n] at index x - 1
        for (int i = 0; i < n; i++) {
            while (
                nums[i] >= 1 &&
                nums[i] <= n &&
                nums[nums[i] - 1] != nums[i]
            ) {
                int targetIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[targetIndex];
                nums[targetIndex] = temp;
            }
        }

        // Find the first index where the expected positive integer is missing
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}