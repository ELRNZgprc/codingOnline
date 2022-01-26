package leetcode.problem;

/**
 * 2073. 买票需要的时间
 * https://leetcode-cn.com/problems/time-needed-to-buy-tickets/
 */
public class TimeRequiredToBuy {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans += Math.min(tickets[i], tickets[k]);
        }
        ans += tickets[k];
        for (int i = k + 1; i < tickets.length; i++) {
            ans += Math.min(tickets[i], tickets[k] - 1);
        }
        return ans;
    }
}
