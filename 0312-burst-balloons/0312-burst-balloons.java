class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        // Pad nums with 1 at both ends
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            newNums[i + 1] = nums[i];
        }

        int len = n + 2;
        int[][] dp = new int[len][len];

        // Length of the interval
        for (int length = 2; length < len; length++) {
            for (int left = 0; left < len - length; left++) {
                int right = left + length;
                
                // Try every balloon k as the *last* balloon to burst in range (left, right)
                for (int k = left + 1; k < right; k++) {
                    int coins = newNums[left] * newNums[k] * newNums[right] 
                              + dp[left][k] 
                              + dp[k][right];
                    
                    dp[left][right] = Math.max(dp[left][right], coins);
                }
            }
        }

        return dp[0][len - 1];
    }
}