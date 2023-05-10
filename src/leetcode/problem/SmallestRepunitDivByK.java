package leetcode.problem;

/**
 * 1015. 可被 K 整除的最小整数
 * https://leetcode.cn/problems/smallest-integer-divisible-by-k/
 */
public class SmallestRepunitDivByK {
    public int smallestRepunitDivByK(int k) {
        int p = 0;
        for (int i = 1; i <= k; i++) {
            p = (p * 10 + 1) % k;
            if (p == 0) {
                return i;
            }
        }
        return -1;
    }
}
