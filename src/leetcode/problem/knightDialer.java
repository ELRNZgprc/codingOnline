package leetcode.problem;

public class knightDialer {
    /**
     * 935
     * https://leetcode-cn.com/problems/knight-dialer/
     */
    public int knightDialer(int N) {
        if (N == 1) {
            return 10;
        }
        int[] record = new int[10];
        int[] cache = new int[10];
        for (int i = 0; i < 10; i++) {
            record[i] = 1;
        }
        for (int k = 1; k < N; k++) {
            cache[0] = record[4] + record[6];
            cache[1] = record[8] + record[6];
            cache[2] = record[7] + record[9];
            cache[3] = record[4] + record[8];
            cache[4] = (record[3] + record[9]) % 1000000007 + record[0];
            cache[5] = 0;
            cache[6] = (record[1] + record[7]) % 1000000007 + record[0];
            cache[7] = record[2] + record[6];
            cache[8] = record[1] + record[3];
            cache[9] = record[4] + record[2];
            for (int i = 0; i < 10; i++) {
                record[i] = cache[i] % 1000000007;
            }
        }
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans = (ans + record[i]) % 1000000007;
        }
        return ans;
    }
}
