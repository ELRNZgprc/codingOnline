package leetcode.problem;

public class IsHappy {
    /**
     * 202. 快乐数
     * https://leetcode-cn.com/problems/happy-number/
     */
    public boolean isHappy(int n) {
        if (n == 4) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        int m = 0;
        while (n > 0) {
            m += (n % 10) * (n % 10);
            n /= 10;
        }
        return isHappy(m);
    }
}
