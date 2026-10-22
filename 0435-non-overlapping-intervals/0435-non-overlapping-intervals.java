import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        // Sort intervals based on their end times in ascending order
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int removeCount = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            // If there is an overlap
            if (currentStart < prevEnd) {
                removeCount++;
            } else {
                // No overlap, update prevEnd to current interval's end
                prevEnd = currentEnd;
            }
        }

        return removeCount;
    }
}