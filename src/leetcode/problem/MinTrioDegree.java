package leetcode.problem;

/**
 * 1761. 一个图中连通三元组的最小度数
 * https://leetcode.cn/problems/minimum-degree-of-a-connected-trio-in-a-graph/description/
 */
public class MinTrioDegree {
    public int minTrioDegree(int n, int[][] edges) {
        boolean[][] matrix = new boolean[n][n];
        short[] degree = new short[n];

        for (int[] e : edges) {
            matrix[e[0] - 1][e[1] - 1] = true;
            matrix[e[1] - 1][e[0] - 1] = true;

            degree[e[0] - 1]++;
            degree[e[1] - 1]++;
        }

        int minDegree = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            if (degree[i] < 2) continue;

            for (int j = i + 1; j < n - 1; j++) {
                if (degree[j] < 2) continue;
                if (!matrix[j][i]) continue;

                for (int k = j + 1; k < n; k++) {
                    boolean is3 = matrix[i][k] && matrix[j][k];
                    if (!is3) continue;

                    minDegree = Math.min(minDegree, degree[i] + degree[j] + degree[k] - 6);
                }
            }
        }
        if (minDegree == Integer.MAX_VALUE) return -1;
        return minDegree;
    }
}
