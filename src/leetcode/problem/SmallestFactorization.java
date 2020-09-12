package leetcode.problem;

public class SmallestFactorization {
    /**
     * 625. 最小因式分解
     * https://leetcode-cn.com/problems/minimum-factorization/
     */
    public int smallestFactorization(int a) {
        if (a < 10) {
            return a;
        }
        int dig = 0;
        long ans = 0;
        for (int i = 9; i >= 2; i--) {
            while (a % i == 0) {
                ans += i * Math.pow(10, dig);
                if (ans > Integer.MAX_VALUE) {
                    return 0;
                }
                dig++;
                a /= i;
            }

        }
        if (a == 1) {
            return (int) ans;
        }
        return 0;
    }
}
