class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        int held = Integer.MIN_VALUE;
        int sold = 0;
        int reset = 0;

        for (int price : prices) {
            int prevHeld = held;
            int prevSold = sold;
            int prevReset = reset;

            // State Transitions
            held = Math.max(prevHeld, prevReset - price);
            sold = prevHeld + price;
            reset = Math.max(prevReset, prevSold);
        }

        // Maximum profit can only be achieved if we don't hold stock at the end
        return Math.max(sold, reset);
    }
}