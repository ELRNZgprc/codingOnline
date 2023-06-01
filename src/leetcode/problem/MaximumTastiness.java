package leetcode.problem;

import java.util.Arrays;

/**
 * 2517. 礼盒的最大甜蜜度
 * https://leetcode.cn/problems/maximum-tastiness-of-candy-basket
 */
public class MaximumTastiness {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < price.length; i++) {
            min = Math.min(price[i] - price[i - 1], min);
        }
        int l = min, r = price[price.length - 1] - price[0];
        while (l <= r) {
            int mid = (l + r) / 2;
            int cnt = 1;
            int cur = price[0];
            for (int i = 1; i < price.length; i++) {
                if (price[i] - cur >= mid) {
                    ++cnt;
                    cur = price[i];
                }
            }
            if (cnt >= k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }
}
