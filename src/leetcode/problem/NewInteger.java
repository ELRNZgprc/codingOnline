package leetcode.problem;

public class NewInteger {
    /**
     * 660. 移除 9
     * https://leetcode-cn.com/problems/remove-9/
     */
    public int newInteger(int n) {
//        return Integer.parseInt(Integer.toString(n, 9));
        int ans = 0;
        int bit = 0;
        while (n > 0) {
            ans += n % 9 * Math.pow(10, bit);
            bit++;
            n /= 9;
        }
        return ans;
    }
}
