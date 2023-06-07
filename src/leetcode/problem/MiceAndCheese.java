package leetcode.problem;

import java.util.Arrays;

/**
 * 2611. 老鼠和奶酪
 * https://leetcode.cn/problems/mice-and-cheese/
 */
public class MiceAndCheese {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int[] diff = new int[reward1.length];
        int count = 0;
        for (int i = 0; i < reward1.length; i++) {
            diff[i] = reward1[i] - reward2[i];
            count += reward2[i];
        }
        Arrays.sort(diff);
        for (int i = 0; i < k; i++) {
            count += diff[diff.length - 1 - i];
        }
        return count;
    }
}
