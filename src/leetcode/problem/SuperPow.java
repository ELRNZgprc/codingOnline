package leetcode.problem;

/**
 * 372. 超级次方
 * https://leetcode.cn/problems/super-pow/
 */
public class SuperPow {
    public int superPow(int a, int[] b) {
        int ans = 1;
        a %= 1337;
        for (int j : b) {
            ans = cifang(ans, 10) * cifang(a, j) % 1337;
        }
        return ans;
    }

    public int cifang(int a, int p) {
        if (p == 0) {
            return 1;
        }
        if (p == 1) {
            return a;
        }
        return cifang(a, p / 2) * cifang(a, p - p / 2) % 1337;
    }
}
