package leetcode.problem;

public class CountServers {
    /**
     * 1267. 统计参与通信的服务器
     * https://leetcode-cn.com/problems/count-servers-that-communicate/
     */
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] flagN = new int[n];
        int[] flagM = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    flagM[j]++;
                    flagN[i]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((grid[i][j] == 1) && ((flagM[j] > 1) || (flagN[i] > 1))) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
