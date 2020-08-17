package leetcode.problem;

public class reverse {
    /**
     * 7
     * https://leetcode-cn.com/problems/reverse-integer/
     */
    public int reverse(int x) {
        int max = 0x7fffffff, min = 0x80000000;
        long rs = 0;
        for (; x != 0; rs = rs * 10 + x % 10, x /= 10) ;
        return ((rs > max) || (rs < min)) ? 0 : (int) rs;
    }
}
