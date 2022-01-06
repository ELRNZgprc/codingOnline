package leetcode.problem;

/**
 * 829. 连续整数求和
 * https://leetcode-cn.com/problems/consecutive-numbers-sum/
 */
public class ConsecutiveNumbersSum {
    public int consecutiveNumbersSum(int n) {
        int ans = 0;
        for (int i = 1; n > 0; i++) {
            if (n % i == 0) {
                ans++;
            }
            n -= i;
        }
        return ans;
    }
}
