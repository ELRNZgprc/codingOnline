package leetcode.problem;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 853. 车队
 * https://leetcode-cn.com/problems/car-fleet/
 */
public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position == null || position.length == 0) {
            return 0;
        }
        int ans = 1;
        int[][] all = new int[position.length][2];
        for (int i = 0; i < position.length; i ++) {
            all[i][0] = position[i];
            all[i][1] = speed[i];
        }
        Arrays.sort(all, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] != o1[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });
        double time = ((double) (target - all[0][0])) /  all[0][1];
        for (int i = 1; i < all.length ; i ++) {
            double t = ((double) (target - all[i][0])) /  all[i][1];
            if (t > time) {
                time = t;
                ans ++;
            }
        }
        return ans;
    }
}
