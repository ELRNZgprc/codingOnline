package leetcode.problem;

import java.util.Arrays;

/**
 * 1012. 至少有 1 位重复的数字
 * https://leetcode.cn/problems/numbers-with-repeated-digits/
 */
public class NumDupDigitsAtMostN {
    int count;

    public int numDupDigitsAtMostN(int n) {
        count = 0;
        boolean[] flag = new boolean[10];
        Arrays.fill(flag, false);
        dfs(0, flag, n);
        return n - count;
    }

    public void dfs(int n, boolean[] flag, int max) {
        if (n <= max) {
            for (int i = 0; i < 10; i++) {
                if (!flag[i]) {
                    long k = n * 10L + i;
                    if ((k > 0) && (k <= max)) {
                        count++;
                        flag[i] = true;
                        dfs((int) k, flag, max);
                        flag[i] = false;
                    }
                }
            }
        }
    }
}
