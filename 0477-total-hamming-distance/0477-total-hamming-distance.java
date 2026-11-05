class Solution {
    public int totalHammingDistance(int[] nums) {
        int totalDistance = 0;
        int n = nums.length;

        // Iterate through all 32 bit positions
        for (int i = 0; i < 32; i++) {
            int onesCount = 0;
            
            for (int num : nums) {
                // Check if the i-th bit is set (1)
                if ((num & (1 << i)) != 0) {
                    onesCount++;
                }
            }

            int zerosCount = n - onesCount;
            // Pairs that differ at this bit position
            totalDistance += onesCount * zerosCount;
        }

        return totalDistance;
    }
}