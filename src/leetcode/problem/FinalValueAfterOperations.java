package leetcode.problem;

/**
 * 2011. 执行操作后的变量值
 * https://leetcode.cn/problems/final-value-of-variable-after-performing-operations/
 */
public class FinalValueAfterOperations {
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for (String s : operations) {
            if (s.charAt(1) == '+') {
                ans++;
            } else {
                ans--;
            }
        }
        return ans;
    }
}
