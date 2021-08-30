package leetcode.problem;

/**
 * 1689. 十-二进制数的最少数目
 * https://leetcode-cn.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
 */
public class MinPartitions {
    public int minPartitions(String n) {
        int ans = 0;
        for (char c : n.toCharArray()) {
            ans = Math.max(ans, c - '0');
        }
        return ans;
    }
}
