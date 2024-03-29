package leetcode.problem;

/**
 * 892. 三维形体的表面积
 * https://leetcode.cn/problems/surface-area-of-3d-shapes/
 */
public class SurfaceArea {
    public int surfaceArea(int[][] grid) {
        int n = grid.length, area = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int level = grid[i][j];
                if (level > 0) {
                    area += (level << 2) + 2;
                    area -= i > 0 ? Math.min(level, grid[i - 1][j]) << 1 : 0;
                    area -= j > 0 ? Math.min(level, grid[i][j - 1]) << 1 : 0;
                }
            }
        }
        return area;
    }
}
