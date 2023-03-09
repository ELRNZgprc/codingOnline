package leetcode.problem;

/**
 * 2379. 得到 K 个黑块的最少涂色次数
 * https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
 */
public class MinimumRecolors {
    public int minimumRecolors(String blocks, int k) {
        char[] c = blocks.toCharArray();
        int b = 0;
        for (int i = 0; i < k; i++) {
            if (c[i] == 'B') {
                b++;
            }
        }
        int ans = k - b;
        for (int i = k; i < c.length; i++) {
            if (c[i] == 'B') {
                b++;
            }
            if (c[i - k] == 'B') {
                b--;
            }
            ans = Math.min(ans, k - b);
        }
        return ans;
    }
}
