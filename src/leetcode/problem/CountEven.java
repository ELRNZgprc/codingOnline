package leetcode.problem;

/**
 * 2180. 统计各位数字之和为偶数的整数个数
 * https://leetcode.cn/problems/count-integers-with-even-digit-sum/
 */
public class CountEven {
    public int countEven(int num) {
        int ans = 0;
        for (int i = 1; i <= num; i++) {
            int sum = 0, a = i;
            while (a > 0) {
                sum += a % 10;
                a /= 10;
            }
            ans += sum & 1 ^ 1;
        }
        return ans;
    }
}
