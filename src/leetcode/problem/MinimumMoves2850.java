package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 2850. 将石头分散到网格图的最少移动次数
 * https://leetcode.cn/problems/minimum-moves-to-spread-stones-over-grid/
 */
public class MinimumMoves2850 {
    int res = Integer.MAX_VALUE;

    public int minimumMoves(int[][] grid) {
        List<int[]> start = new ArrayList<>();
        List<int[]> end = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    end.add(new int[]{i, j, 1});
                } else {
                    start.add(new int[]{i, j, grid[i][j] - 1});
                }
            }
        }
        findMin(start, end, 0, 0);
        return res;
    }

    void findMin(List<int[]> start, List<int[]> end, int sum, int depth) {
        if (sum > res) {
            return;
        }
        if (end.size() == depth) {
            res = sum;
        } else {
            for (int i = 0; i < end.size(); i++) {
                if (end.get(i)[2] > 0) {
                    end.get(i)[2]--;
                    for (int j = 0; j < start.size(); j++) {
                        if (start.get(j)[2] > 0) {
                            start.get(j)[2]--;
                            int dis = Math.abs(end.get(i)[0] - start.get(j)[0]) + Math.abs(end.get(i)[1] - start.get(j)[1]);
                            findMin(start, end, sum + dis, depth + 1);
                            start.get(j)[2]++;
                        }
                    }
                    end.get(i)[2]++;
                }
            }
        }
    }
}
