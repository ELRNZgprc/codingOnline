package leetcode.problem;

public class sumOfDigits {
    /**
     * 1085
     * https://leetcode-cn.com/problems/sum-of-digits-in-the-minimum-number/
     */
    public int sumOfDigits(int[] A) {
        int min = A[0];
        for (int i = 1; i < A.length; i++) {
            min = Math.min(min, A[i]);
        }
        int ans = 0;
        while (min > 0) {
            ans += min % 10;
            min /= 10;
        }
        return (ans % 2 == 1) ? 0 : 1;
    }
}
