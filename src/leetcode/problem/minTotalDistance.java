package leetcode.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class minTotalDistance {
    /**
     * 296
     * https://leetcode-cn.com/problems/best-meeting-point/
     */
    public int minTotalDistance(int[][] grid) {
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    x.add(i);
                    y.add(j);
                }
            }
        }
        Collections.sort(x);
        Collections.sort(y);
        int ans = 0;
        int targetx = x.get(x.size() / 2);
        int targety = y.get(y.size() / 2);
        for (int i = 0; i < x.size(); i++) {
            ans += Math.abs(x.get(i) - targetx) + Math.abs(y.get(i) - targety);
        }
        return ans;
    }
}
