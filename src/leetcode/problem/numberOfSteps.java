package leetcode.problem;

public class numberOfSteps {
    /**
     * 1342
     * https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-to-zero/
     */
    public int numberOfSteps(int num) {
        int ans = 0;
        while (num != 0) {
            ans++;
            if ((num % 2 != 0) && (num != 1)) {
                ans++;
            }
            num /= 2;
        }
        return ans;
    }
}
