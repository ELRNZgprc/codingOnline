package leetcode.problem;

public class numTimesAllBlue {
    /**
     * 1375
     * https://leetcode-cn.com/problems/bulb-switcher-iii/
     */
    public int numTimesAllBlue(int[] light) {
        int ans = 0;
        int max = 0;
        for (int i = 0; i < light.length; i++) {
            max = Math.max(max, light[i]);
            if (i + 1 == max) {
                ans++;
            }
        }
        return ans;
    }
}
