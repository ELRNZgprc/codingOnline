package leetcode.problem;

/**
 * 483. 最小好进制
 * https://leetcode-cn.com/problems/smallest-good-base/
 */
public class SmallestGoodBase {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        for (int x = (int) (Math.log(num + 1) / Math.log(2)); x >= 2; x--) {
            long left = 2;
            long right = (long) Math.pow(num, 1.0 / (x - 1)) + 1;
            while (left < right) {
                long mid = (right - left) / 2 + left;
                long sum = 0;
                for (int i = 0; i < x; i++) {
                    sum = sum * mid + 1;
                }
                if (sum == num) {
                    return String.valueOf(mid);
                } else if (sum > num) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return String.valueOf(num - 1);
    }
}
