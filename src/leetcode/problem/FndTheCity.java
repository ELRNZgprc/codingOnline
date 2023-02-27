package leetcode.problem;

import java.util.Arrays;

/**
 * 1334. 阈值距离内邻居最少的城市
 * https://leetcode.cn/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
 */
public class FndTheCity {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int inf = Integer.MAX_VALUE / 2;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], inf);
        for (int[] e : edges) {
            dist[e[0]][e[1]] = e[2];
            dist[e[1]][e[0]] = e[2];
        }
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) if (i != j) dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
            }
        }
        int ans = -1, tol = inf;
        for (int i = 0; i < n; i++) {
            int cnt = 0, s = 0;
            for (int j = 0; j < n; j++) if (dist[i][j] <= distanceThreshold) cnt++;
            if (cnt <= tol) {
                ans = i;
                tol = cnt;
            }
        }
        return ans;
    }
}