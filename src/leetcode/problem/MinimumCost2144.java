package leetcode.problem;

import java.util.Arrays;

/**
 * 2144. 打折购买糖果的最小开销
 * https://leetcode.cn/problems/minimum-cost-of-buying-candies-with-discount/
 */
public class MinimumCost2144 {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int sum = 0;
        int count = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            if (count == 2) {
                count = 0;
            } else {
                sum += cost[i];
                count++;
            }
        }
        return sum;
    }
}
