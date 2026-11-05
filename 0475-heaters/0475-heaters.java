import java.util.Arrays;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        // Sort heaters to enable binary search
        Arrays.sort(heaters);
        int maxRadius = 0;

        for (int house : houses) {
            int radius = findClosestHeaterDistance(house, heaters);
            maxRadius = Math.max(maxRadius, radius);
        }

        return maxRadius;
    }

    private int findClosestHeaterDistance(int house, int[] heaters) {
        int left = 0;
        int right = heaters.length - 1;
        int closestDist = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int heater = heaters[mid];

            int dist = Math.abs(house - heater);
            closestDist = Math.min(closestDist, dist);

            if (heater == house) {
                return 0; // Exact match, distance is 0
            } else if (heater < house) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return closestDist;
    }
}