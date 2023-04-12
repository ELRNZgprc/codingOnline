package leetcode.problem;

/**
 * 2571. 将整数减少到零需要的最少操作数
 * https://leetcode.cn/problems/minimum-operations-to-reduce-an-integer-to-0/
 */
public class MinOperations2571 {
    public int minOperations(int n) {
        if (n == 0) return 0;
        int res = 0;
        int i = 1;
        while (n > 0) {
            while ((n & i) == 0) {
                i <<= 1;
            }
            i <<= 1;
            if ((n & i) != 0) {  // 遇到一群相连的1，进位消除。
                res += 1;
                n += (i >> 1);
            } else {  // 遇到单独一个1，直接减掉。
                n -= (i >> 1);
                res += 1;
            }
        }
        return  res;
    }
}
