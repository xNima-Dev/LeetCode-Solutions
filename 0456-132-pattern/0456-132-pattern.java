import java.util.Stack;

class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;

        Stack<Integer> stack = new Stack<>();
        int third = Integer.MIN_VALUE; // Represents nums[k]

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            // If we find a number smaller than 'third', 132 pattern exists
            if (nums[i] < third) {
                return true;
            }

            // Pop elements from stack smaller than current nums[i] and update 'third'
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                third = stack.pop();
            }

            // Push current element onto the stack as a potential nums[j]
            stack.push(nums[i]);
        }

        return false;
    }
}