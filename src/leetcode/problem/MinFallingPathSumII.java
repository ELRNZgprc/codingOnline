package leetcode.problem;

/**
 * 1289. 下降路径最小和  II
 * https://leetcode.cn/problems/minimum-falling-path-sum-ii/
 */
public class MinFallingPathSumII {
    public int minFallingPathSum(int[][] grid) {
        if(grid.length == 1){
            return grid[0][0];
        }
        for(int i = 1; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                int min = Integer.MAX_VALUE;
                for(int k = 0; k < grid.length; k++){
                    if(k != j) min = Math.min(grid[i - 1][k], min);
                }
                grid[i][j] += min;
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < grid.length; i++){
            res = Math.min(res, grid[grid.length - 1][i]);
        }
        return res;
    }
}
