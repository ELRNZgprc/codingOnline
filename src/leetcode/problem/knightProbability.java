package leetcode.problem;

public class knightProbability {
    /**
     * 688
     * https://leetcode-cn.com/problems/knight-probability-in-chessboard/
     */
    double[][][] memo688 = new double[101][26][26];
    int[][] directions688 = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {1, -2}, {2, -1}, {-1, -2}, {-2, -1}};

    public double knightProbability(int N, int K, int r, int c) {
        if ((r < 0) || (r >= N) || (c < 0) || (c >= N)) {
            return 0;
        }
        if (K == 0) {
            return 1;
        }
        if (memo688[K][r][c] != 0) {
            return memo688[K][r][c];
        }
        double ans = 0;
        for (int[] direction : directions688) {
            ans += knightProbability(N, K - 1, r + direction[0], c + direction[1]);
        }
        ans /= 8.0;
        memo688[K][r][c] = ans;
        return ans;
    }
}
