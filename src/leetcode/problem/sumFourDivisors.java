package leetcode.problem;

public class sumFourDivisors {
    /**
     * 1390
     * https://leetcode-cn.com/problems/four-divisors/
     */
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans += isFourDivisors(num);
        }
        return ans;
    }

    int isFourDivisors(int a) {
        int ans = 1 + a;
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                if ((ans != 1 + a) || (i * i == a)) {
                    return 0;
                } else {
                    ans += i + a / i;
                }
            }
        }
        if (ans == 1 + a) {
            return 0;
        }
        return ans;
    }
}
