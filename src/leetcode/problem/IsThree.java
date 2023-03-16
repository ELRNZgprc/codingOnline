package leetcode.problem;

/**
 * 1952. 三除数
 * https://leetcode.cn/problems/three-divisors/
 */
public class IsThree {
    public boolean isThree(int n) {
        if (n == 1) {
            return false;
        }
        int sqrt = (int) Math.round(Math.sqrt(n));
        if (sqrt * sqrt != n) {
            return false;
        }
        return isPrime(sqrt);
    }

    public boolean isPrime(int n) {
        int sqrt = (int) Math.round(Math.sqrt(n));
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
