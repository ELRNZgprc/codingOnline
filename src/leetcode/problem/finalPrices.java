package leetcode.problem;

public class finalPrices {
    /**
     * 1475
     * https://leetcode-cn.com/problems/final-prices-with-a-special-discount-in-a-shop/
     */
    public int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int j = i + 1;
            while ((j < prices.length) && (prices[j] > prices[i])) {
                j++;
            }
            if (j < prices.length) {
                ans[i] = prices[i] - prices[j];
            } else {
                ans[i] = prices[i];
            }
        }

        return ans;
    }
}
