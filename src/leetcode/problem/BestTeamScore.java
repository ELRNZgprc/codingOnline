package leetcode.problem;

import java.util.Arrays;

/**
 * 1626. 无矛盾的最佳球队
 * https://leetcode.cn/problems/best-team-with-no-conflicts/
 */
public class BestTeamScore {
    public int bestTeamScore(int[] scores, int[] ages) {
        int length = scores.length;
        int[][] players = new int[length][2];
        for (int i = 0; i < length; i++) {
            players[i][0] = ages[i];
            players[i][1] = scores[i];
        }
        Arrays.sort(players, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int[] dp = new int[length];
        int ans = 0;
        for (int i = 0; i < length; i++) {
            dp[i] = players[i][1];
            for (int j = 0; j < i; j++) {
                if (players[j][1] <= players[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + players[i][1]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
