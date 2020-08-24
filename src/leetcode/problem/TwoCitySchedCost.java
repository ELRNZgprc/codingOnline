package leetcode.problem;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCitySchedCost {
    /**
     * 1029. 两地调度
     * https://leetcode-cn.com/problems/two-city-scheduling/
     */
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o1[1] - o2[0] + o2[1];
            }
        });
        int ans = 0;
        int length = costs.length / 2;
        for (int i = 0; i < length; i++) {
            ans += costs[i][0] + costs[i + length][1];
        }
        return ans;
    }
}
