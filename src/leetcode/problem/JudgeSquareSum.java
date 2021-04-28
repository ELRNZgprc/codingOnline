package leetcode.problem;

/**
 * 633. 平方数之和
 * https://leetcode-cn.com/problems/sum-of-square-numbers/
 */
public class JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        int a = 0;
        int b = (int) Math.sqrt(c);
        while (a <= b) {
            if (a * a + b * b == c) {
                return true;
            } else if (a * a + b * b < c) {
                a++;
            } else {
                b--;
            }
        }
        return false;
    }
}
