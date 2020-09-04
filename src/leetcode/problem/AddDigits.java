package leetcode.problem;

public class AddDigits {
    /**
     * 258. 各位相加
     * https://leetcode-cn.com/problems/add-digits/
     */
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
