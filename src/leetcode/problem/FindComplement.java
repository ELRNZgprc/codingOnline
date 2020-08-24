package leetcode.problem;

public class FindComplement {
    /**
     * 476. 数字的补数
     * https://leetcode-cn.com/problems/number-complement/
     */
    public int findComplement(int num) {
        int i = 1;
        while (i < num) {
            i = i * 2 + 1;
        }
        return i - num;
    }
}
