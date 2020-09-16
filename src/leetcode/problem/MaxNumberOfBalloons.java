package leetcode.problem;

public class MaxNumberOfBalloons {
    /**
     * 1189. “气球” 的最大数量
     * https://leetcode-cn.com/problems/maximum-number-of-balloons/
     */
    public int maxNumberOfBalloons(String text) {
        int b = 0;
        int a = 0;
        int l = 0;
        int o = 0;
        int n = 0;
        for (char c : text.toCharArray()) {
            switch (c) {
                case 'b':
                    b++;
                    break;
                case 'a':
                    a++;
                    break;
                case 'l':
                    l++;
                    break;
                case 'o':
                    o++;
                    break;
                case 'n':
                    n++;
            }
        }
        int ans = b;
        ans = Math.min(ans, a);
        ans = Math.min(ans, l / 2);
        ans = Math.min(ans, o / 2);
        ans = Math.min(ans, n);
        return ans;
    }
}
