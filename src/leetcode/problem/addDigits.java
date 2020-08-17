package leetcode.problem;

public class addDigits {
    /**
     * 258
     * https://leetcode-cn.com/problems/add-digits/
     */
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
