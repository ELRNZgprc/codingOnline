package leetcode.problem;

import java.util.List;

public class MinimumTotal {
    /**
     * 120. 三角形最小路径和
     * https://leetcode-cn.com/problems/triangle/
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] re = {0, -1};
        if (triangle.size() == 0) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int min = Integer.MAX_VALUE;
                for (int r : re) {
                    if (((j + r) >= 0) && (j + r < triangle.get(i - 1).size())) {
                        min = Math.min(min, triangle.get(i - 1).get(j + r));
                    }
                }
                triangle.get(i).set(j, triangle.get(i).get(j) + min);
            }
        }
        int min = triangle.get(triangle.size() - 1).get(0);
        for (int an : triangle.get(triangle.size() - 1)) {
            min = Math.min(min, an);
        }
        return min;
    }
}
