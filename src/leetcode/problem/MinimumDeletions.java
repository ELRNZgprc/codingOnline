package leetcode.problem;

/**
 * 1653. 使字符串平衡的最少删除次数
 * https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced/
 */
public class MinimumDeletions {
    public int minimumDeletions(String s) {
        int countB = 0, dp = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                dp = Math.min(dp + 1, countB);
            } else {
                countB++;
            }
        }
        return dp;
    }
}
