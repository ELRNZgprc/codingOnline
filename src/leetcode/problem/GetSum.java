package leetcode.problem;

/**
 * 371. 两整数之和
 * https://leetcode-cn.com/problems/sum-of-two-integers/
 */
public class GetSum {
    public int getSum(int a, int b) {
        int sum = a ^ b;
        int carry = (a & b) << 1;
        if (carry == 0) {
            return sum;
        }
        return getSum(sum, carry);
    }
}
