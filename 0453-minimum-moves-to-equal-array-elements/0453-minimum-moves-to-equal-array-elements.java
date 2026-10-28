class Solution {
    public int minMoves(int[] nums) {
        int minVal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < minVal) {
                minVal = nums[i];
            }
        }

        int moves = 0;
        for (int num : nums) {
            moves += (num - minVal);
        }

        return moves;
    }
}