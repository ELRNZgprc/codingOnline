package leetcode.problem;

import java.util.Arrays;

public class FindMinArrowShots {
    /**
     * 452. 用最少数量的箭引爆气球
     * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
     */
    public int findMinArrowShots(int[][] points) {
        if (points.length < 1) {
            return 0;
        }
        Arrays.sort(points, (o1, o2) -> (o1[1] - o2[1]));
        int ans = 1;
        int position = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > position) {
                ans++;
                position = points[i][1];
            }
        }
        return ans;
    }
}
