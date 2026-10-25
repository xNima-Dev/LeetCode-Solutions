import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int boomerangs = 0;
        int n = points.length;

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> distMap = new HashMap<>();
            
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                int dist = dx * dx + dy * dy; // Squared distance
                
                distMap.put(dist, distMap.getOrDefault(dist, 0) + 1);
            }

            // Calculate combinations for each distance frequency
            for (int count : distMap.values()) {
                if (count > 1) {
                    boomerangs += count * (count - 1);
                }
            }
        }

        return boomerangs;
    }
}