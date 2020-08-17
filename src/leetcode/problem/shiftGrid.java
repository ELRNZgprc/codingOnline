package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class shiftGrid {
    /**
     * 1260
     * https://leetcode-cn.com/problems/shift-2d-grid/
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[] nums = new int[m * n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                k = k % (m * n);
                nums[k++] = grid[i][j];
            }
        }

        k = 0;

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                list.add(nums[k++]);
            }
            ans.add(list);
        }
        return ans;
    }
}
