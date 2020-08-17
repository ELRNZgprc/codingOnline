package leetcode.problem;

public class countOrders {
    /**
     * 1359
     * https://leetcode-cn.com/problems/count-all-valid-pickup-and-delivery-options/
     */
    public int countOrders(int n) {
        long ans = 1;
        for (int i = 2; i <= n; i++) {
            ans = ans * i * (2 * i - 1);
            if (ans > 1000000007) {
                ans %= 1000000007;
            }
        }
        return (int) ans;
    }
}
