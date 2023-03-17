package leetcode.problem;

/**
 * 1317. 将整数转换为两个无零整数的和
 * https://leetcode.cn/problems/convert-integer-to-the-sum-of-two-no-zero-integers/
 */
public class GetNoZeroIntegers {
    public int[] getNoZeroIntegers(int n) {
        int ans = 1;
        while (containZero(ans) || containZero(n - ans)) {
            ans++;
        }
        return new int[]{ans, n - ans};
    }

    public boolean containZero(int i) {
        while (i > 0) {
            if (i % 10 == 0) {
                return true;
            }
            i /= 10;
        }
        return false;
    }
}
