import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        // Store [start, end, originalIndex]
        int[][] starts = new int[n][3];
        for (int i = 0; i < n; i++) {
            starts[i][0] = intervals[i][0];
            starts[i][1] = intervals[i][1];
            starts[i][2] = i;
        }

        // Sort by start times in ascending order
        Arrays.sort(starts, Comparator.comparingInt(a -> a[0]));

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int targetEnd = intervals[i][1];
            int left = 0;
            int right = n - 1;
            int rightIndex = -1;

            // Binary search for the smallest start >= targetEnd
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (starts[mid][0] >= targetEnd) {
                    rightIndex = starts[mid][2]; // Save the original index
                    right = mid - 1; // Try to find a smaller valid start on the left
                } else {
                    left = mid + 1;
                }
            }

            result[i] = rightIndex;
        }

        return result;
    }
}