import java.util.Arrays;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;

        // Step 1: Sort envelopes
        // Width ascending; if widths are equal, height descending
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // Descending height
            }
            return a[0] - b[0];     // Ascending width
        });

        // Step 2: Find LIS on heights using Binary Search (Patience Sorting)
        int[] tails = new int[envelopes.length];
        int size = 0;

        for (int[] env : envelopes) {
            int h = env[1];
            int left = 0, right = size - 1;

            // Binary search for insertion point
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] < h) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            tails[left] = h;
            if (left == size) {
                size++;
            }
        }

        return size;
    }
}