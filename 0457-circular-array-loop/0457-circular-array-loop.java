class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;

            boolean isForward = nums[i] >= 0;
            int slow = i;
            int fast = i;

            // Fast & Slow pointer traversal
            while (true) {
                slow = getNextIndex(nums, slow, isForward);
                fast = getNextIndex(nums, fast, isForward);

                if (fast != -1) {
                    fast = getNextIndex(nums, fast, isForward);
                }

                // If any pointer hits an invalid path, break
                if (slow == -1 || fast == -1) {
                    break;
                }

                // Cycle detected
                if (slow == fast) {
                    return true;
                }
            }

            // Mark visited path as 0 to optimize future iterations
            int current = i;
            while (nums[current] != 0 && (nums[current] >= 0) == isForward) {
                int next = (current + nums[current]) % n;
                int normalizedNext = next < 0 ? next + n : next;
                nums[current] = 0;
                current = normalizedNext;
            }
        }

        return false;
    }

    private int getNextIndex(int[] nums, int i, boolean isForward) {
        int n = nums.length;
        boolean currentDirection = nums[i] >= 0;

        // Direction mismatch check
        if (isForward != currentDirection) {
            return -1;
        }

        int next = (i + nums[i]) % n;
        if (next < 0) {
            next += n; // Handle negative indices
        }

        // Self loop check (k = 1 is invalid)
        if (next == i) {
            return -1;
        }

        return next;
    }
}