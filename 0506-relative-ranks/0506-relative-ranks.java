import java.util.Arrays;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];

        // [score, originalIndex] pairs array එකක් නිර්මාණය කරයි
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = score[i];
            pairs[i][1] = i;
        }

        // Scores අනුව Descending order එකට Sort කරයි
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);

        // Ranks Assign කරයි
        for (int i = 0; i < n; i++) {
            int originalIndex = pairs[i][1];

            if (i == 0) {
                result[originalIndex] = "Gold Medal";
            } else if (i == 1) {
                result[originalIndex] = "Silver Medal";
            } else if (i == 2) {
                result[originalIndex] = "Bronze Medal";
            } else {
                result[originalIndex] = String.valueOf(i + 1);
            }
        }

        return result;
    }
}