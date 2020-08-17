package leetcode.problem;

public class judgePoint24 {
    /**
     * 679
     * https://leetcode-cn.com/problems/24-game/
     */
    public boolean judgePoint24(int[] nums) {
        double a = nums[0];
        double b = nums[1];
        double c = nums[2];
        double d = nums[3];
        return judge3(a + b, c, d) ||
                judge3(a - b, c, d) ||
                judge3(b - a, c, d) ||
                judge3(a * b, c, d) ||
                judge3(a / b, c, d) ||
                judge3(b / a, c, d) ||
                judge3(a + c, b, d) ||
                judge3(a - c, b, d) ||
                judge3(c - a, b, d) ||
                judge3(a * c, b, d) ||
                judge3(a / c, b, d) ||
                judge3(c / a, b, d) ||
                judge3(a + d, b, c) ||
                judge3(a - d, b, c) ||
                judge3(d - a, b, c) ||
                judge3(a * d, b, c) ||
                judge3(a / d, b, c) ||
                judge3(d / a, b, c) ||
                judge3(b + c, a, d) ||
                judge3(b - c, a, d) ||
                judge3(c - b, a, d) ||
                judge3(b * c, a, d) ||
                judge3(b / c, a, d) ||
                judge3(c / b, a, d) ||
                judge3(b + d, a, c) ||
                judge3(b - d, a, c) ||
                judge3(d - b, a, c) ||
                judge3(b * d, a, c) ||
                judge3(b / d, a, c) ||
                judge3(d / b, a, c) ||
                judge3(c + d, a, b) ||
                judge3(c - d, a, b) ||
                judge3(d - c, a, b) ||
                judge3(c * d, a, b) ||
                judge3(c / d, a, b) ||
                judge3(d / c, a, b);
    }

    boolean judge3(double a, double b, double c) {
        return judge(a + b, c) ||
                judge(a - b, c) ||
                judge(b - a, c) ||
                judge(a * b, c) ||
                judge(a / b, c) ||
                judge(b / a, c) ||
                judge(a + c, b) ||
                judge(a - c, b) ||
                judge(c - a, b) ||
                judge(a * c, b) ||
                judge(a / c, b) ||
                judge(c / a, b) ||
                judge(b + c, a) ||
                judge(b - c, a) ||
                judge(c - b, a) ||
                judge(b * c, a) ||
                judge(b / c, a) ||
                judge(c / b, a);
    }

    boolean judge(double a, double b) {
        return (Math.abs(a + b - 24) < 0.01) ||
                (Math.abs(a - b - 24) < 0.01) ||
                (Math.abs(b - a - 24) < 0.01) ||
                (Math.abs(a * b - 24) < 0.01) ||
                (Math.abs(a / b - 24) < 0.01) ||
                (Math.abs(b / a - 24) < 0.01);
    }
}
