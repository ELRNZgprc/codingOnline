package leetcode.problem;

/**
 * 1615. 最大网络秩
 * https://leetcode.cn/problems/maximal-network-rank/
 */
public class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] roadTable = new int[n][n];
        int[] hash = new int[n];
        for (int[] road : roads) {
            roadTable[road[0]][road[1]] = 1;
            roadTable[road[1]][road[0]] = 1;
            hash[road[0]]++;
            hash[road[1]]++;
        }
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = hash[i] + hash[j];
                if (roadTable[i][j] > 0) {
                    sum--;
                }
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}
