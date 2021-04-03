package leetcode.offer;

public class CuttingRope {
    /**
     * 剑指 Offer 14- I. 剪绳子
     * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
     */
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int div = n / 3;
        int rem = n % 3;
        long result = 1;
        for (int i = 0; i < div; i++) {
            result *= i < div - 1 ? 3 : (rem == 2 ? 3 * rem : (3 + rem));
            if (result >= 1000000007) {
                result = result % 1000000007;
            }
        }
        return (int) result;
    }

}
