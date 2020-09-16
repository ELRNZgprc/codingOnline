package leetcode.problem;

public class FindPoisonedDuration {
    /**
     * 495. 提莫攻击
     * https://leetcode-cn.com/problems/teemo-attacking/
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length < 1) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            ans += Math.min(duration, timeSeries[i + 1] - timeSeries[i]);
        }
        ans += duration;
        return ans;
    }
}
