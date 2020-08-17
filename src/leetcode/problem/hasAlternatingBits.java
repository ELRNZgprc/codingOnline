package leetcode.problem;

public class hasAlternatingBits {
    /**
     * 693
     * https://leetcode-cn.com/problems/binary-number-with-alternating-bits/
     */
    public boolean hasAlternatingBits(int n) {
        int last = n % 2;

        while (n > 1) {
            n = n >> 1;
            if (last == (n % 2)) {
                return false;
            }
            last = n % 2;
        }
        return true;
    }
}
