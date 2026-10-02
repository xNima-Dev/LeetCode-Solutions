class Solution {
    public void moveZeroes(int[] nums) {
        int insertIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Non-Zero Element එකක් හමුවූ විට Swap කරයි
                if (i != insertIndex) {
                    int temp = nums[i];
                    nums[i] = nums[insertIndex];
                    nums[insertIndex] = temp;
                }
                insertIndex++;
            }
        }
    }
}