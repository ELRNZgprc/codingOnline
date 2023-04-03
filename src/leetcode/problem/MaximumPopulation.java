package leetcode.problem;

/**
 * 1854. 人口最多的年份
 * https://leetcode.cn/problems/maximum-population-year/
 */
public class MaximumPopulation {
    public int maximumPopulation(int[][] logs) {
        int[] change = new int[101];
        for (int[] log : logs) {
            change[log[0] - 1950]++;
            change[log[1] - 1950]--;
        }
        int res = 0, max = 0, index = 0;
        for (int i = 0; i < change.length; i++) {
            res += change[i];
            if (res > max) {
                max = res;
                index = 1950 + i;
            }
        }
        return index;
    }
}
