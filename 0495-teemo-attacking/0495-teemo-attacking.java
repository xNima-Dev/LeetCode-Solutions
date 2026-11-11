class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;

        int totalPoisonedTime = 0;

        for (int i = 0; i < timeSeries.length - 1; i++) {
            int diff = timeSeries[i + 1] - timeSeries[i];
            // If the time between attacks is less than duration, add the diff
            // Otherwise, add the full duration
            totalPoisonedTime += Math.min(diff, duration);
        }

        // The last attack always lasts for the full duration
        totalPoisonedTime += duration;

        return totalPoisonedTime;
    }
}