import java.util.Arrays;

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;

        int k = primes.length;
        int[] pointers = new int[k];

        for (int i = 1; i < n; i++) {
            long nextUgly = Long.MAX_VALUE;

            // Find the minimum next potential ugly number
            for (int j = 0; j < k; j++) {
                long candidate = (long) ugly[pointers[j]] * primes[j];
                if (candidate < nextUgly) {
                    nextUgly = candidate;
                }
            }

            ugly[i] = (int) nextUgly;

            // Advance pointers that generated this minimum value
            for (int j = 0; j < k; j++) {
                if ((long) ugly[pointers[j]] * primes[j] == nextUgly) {
                    pointers[j]++;
                }
            }
        }

        return ugly[n - 1];
    }
}