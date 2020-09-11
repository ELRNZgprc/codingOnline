package leetcode.problem;

public class CheckPerfectNumber {
    /**
     * 507. 完美数
     * https://leetcode-cn.com/problems/perfect-number/
     */
    public boolean checkPerfectNumber(int num) {
        if (num < 2) {
            return false;
        }
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i != num) {
                    sum += num / i;
                }
            }
        }
        return sum == num;
    }
}
