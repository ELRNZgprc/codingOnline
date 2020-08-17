package leetcode.problem;

import java.util.Arrays;

public class maxSatisfaction {
    /**
     * 1402
     * https://leetcode-cn.com/problems/reducing-dishes/
     */
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int ans = 0;
        int sum = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            sum += satisfaction[i];
            if (sum > 0) {
                ans += sum;
            }
        }
        return ans;
    }
}
