package leetcode.problem;

public class RangeBitwiseAnd {
    /**
     * 201. 数字范围按位与
     * https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
     */
    public int rangeBitwiseAnd(int m, int n) {
        int offset = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            offset++;
        }
        return n << offset;
    }
}
