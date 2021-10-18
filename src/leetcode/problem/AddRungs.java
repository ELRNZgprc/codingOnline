package leetcode.problem;

/**
 * 1936. 新增的最少台阶数
 * https://leetcode-cn.com/problems/add-minimum-number-of-rungs/
 */
public class AddRungs {
    public int addRungs(int[] rungs, int dist) {
        int ans = (rungs[0] + dist - 1) / dist - 1;
        for (int i = 1; i < rungs.length; i++) {
            ans += (rungs[i] - rungs[i - 1] + dist - 1) / dist - 1;
        }
        return ans;
    }
}
