class Solution {
    public int maxProfit(int[] prices) {
        // find max profit at any given i by startting at i= 1 and going forward
        // i at any given point will be considered as sell price
        int maxProf = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (buy > prices[i]) {
                buy = prices[i];
            }
            int currProfit = prices[i] - buy;
            maxProf = Math.max(currProfit, maxProf);
        }
        return maxProf;
    }
}
