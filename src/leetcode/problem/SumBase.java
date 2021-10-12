package leetcode.problem;

/**
 * 1837. K 进制表示下的各位数字总和
 * https://leetcode-cn.com/problems/sum-of-digits-in-base-k/
 */
public class SumBase {
    public int sumBase(int n, int k) {
        int ans = 0;
        while (n > 0) {
            ans += n % k;
            n /= k;
        }
        return ans;
    }
}
