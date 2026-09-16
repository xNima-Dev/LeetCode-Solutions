import java.util.HashSet;
import java.util.Set;

class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> uniqueTypes = new HashSet<>();
        
        for (int type : candyType) {
            uniqueTypes.add(type);
        }

        int maxAllowed = candyType.length / 2;

        return Math.min(uniqueTypes.size(), maxAllowed);
    }
}