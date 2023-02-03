package leetcode.problem;

import java.util.Arrays;

/**
 * 1387. 将整数按权重排序
 * https://leetcode.cn/problems/sort-integers-by-the-power-value/
 */
public class GetKth {
    public int getKth(int lo, int hi, int k) {
        int len = hi - lo + 1;
        int[][] weight = new int[len][2];
        for (int i = 0; i < len; lo++, i++) {
            weight[i][0] = helper(lo);
            weight[i][1] = lo;
        }
        Arrays.sort(weight, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        return weight[k - 1][1];
    }

    private int helper(int num) {
        int step = 0;
        while (num != 1) {
            if ((num & 1) == 0) {
                num >>>= 1;
            } else {
                num = num * 3 + 1;
            }
            step++;
        }
        return step;
    }
}
