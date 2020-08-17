package leetcode.problem;

public class new21Game {
    /**
     * 837
     * https://leetcode-cn.com/problems/new-21-game/
     */
    public double new21Game(int N, int K, int W) {
        double[] dp = new double[K + W];
        dp[0] = 1.0;
        double pos = 0;
        for (int i = 1; i <= K + W - 1; i++) {
            if (i - W - 1 >= 0) {
                pos -= dp[i - W - 1];
            }
            if (i - 1 < K) {
                pos += dp[i - 1];
            }
            dp[i] = pos * 1.0 / W;
        }
        double sum = 0;
        double usable = 0;
        for (int i = K; i <= N; i++) {
            if (i <= K + W - 1) {
                usable += dp[i];
            }
        }
        for (int i = K; i <= K + W - 1; i++) {
            sum += dp[i];
        }
        return usable / sum;
    }
}
