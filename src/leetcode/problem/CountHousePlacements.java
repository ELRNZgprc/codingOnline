package leetcode.problem;

/**
 * 2320. 统计放置房子的方式数
 * https://leetcode.cn/problems/count-number-of-ways-to-place-houses/
 */
public class CountHousePlacements {
    public int countHousePlacements(int n) {
        int mod = (int) 1e9 + 7;
        long[] ans = {1, 1, 1, 1};
        for (int i = 2; i <= n; i++) {
            ans = new long[]{(ans[0] + ans[1] + ans[2] + ans[3]) % mod, (ans[0] + ans[2]) % mod, (ans[0] + ans[1]) % mod, ans[0]};
        }
        return (int) ((ans[0] + ans[1] + ans[2] + ans[3]) % mod);
    }
}
