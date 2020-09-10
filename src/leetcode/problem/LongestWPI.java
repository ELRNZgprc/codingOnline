package leetcode.problem;

public class LongestWPI {
    /**
     * 1124. 表现良好的最长时间段
     * https://leetcode-cn.com/problems/longest-well-performing-interval/
     */
    public int longestWPI(int[] hours) {
        int[] sum = new int[hours.length];
        sum[0] = (hours[0] > 8) ? 1 : -1;
        for (int i = 1; i < hours.length; i++) {
            sum[i] = sum[i - 1] + ((hours[i] > 8) ? 1 : -1);
        }
        int ans = 0;
        for (int i = 0; i < (sum.length - ans); i++) {
            for (int j = i + ans; j < sum.length; j++) {
                if (i == 0) {
                    if (sum[j] > 0) {
                        ans = Math.max(ans, j + 1);
                    }
                } else {
                    if (sum[j] - sum[i - 1] > 0) {
                        ans = Math.max(ans, j - i + 1);
                    }
                }
            }
        }
        return ans;
    }
}
