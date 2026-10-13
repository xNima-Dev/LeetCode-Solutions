class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] masks = new int[n];
        int[] lengths = new int[n];

        // Precompute bitmasks and lengths for all words
        for (int i = 0; i < n; i++) {
            String word = words[i];
            lengths[i] = word.length();
            int mask = 0;
            for (int j = 0; j < word.length(); j++) {
                mask |= (1 << (word.charAt(j) - 'a'));
            }
            masks[i] = mask;
        }

        int maxProd = 0;

        // Check all pairs
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // If they share no common letters
                if ((masks[i] & masks[j]) == 0) {
                    int prod = lengths[i] * lengths[j];
                    if (prod > maxProd) {
                        maxProd = prod;
                    }
                }
            }
        }

        return maxProd;
    }
}