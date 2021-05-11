package leetcode.problem;

/**
 * 1395. 统计作战单位数
 * https://leetcode-cn.com/problems/count-number-of-teams/
 */
public class NumTeams {
    public int numTeams(int[] rating) {
        int ans = 0;
        for (int i = 1; i < rating.length - 1; i++) {
            int leftless = 0;
            int rightless = 0;
            int leftmore = 0;
            int rightmore = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) {
                    leftless++;
                }
                if (rating[j] > rating[i]) {
                    leftmore++;
                }
            }
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[j] < rating[i]) {
                    rightless++;
                }
                if (rating[j] > rating[i]) {
                    rightmore++;
                }
            }
            ans += leftless * rightmore + leftmore * rightless;
        }
        return ans;
    }
}
