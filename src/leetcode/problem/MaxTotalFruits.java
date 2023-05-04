package leetcode.problem;

/**
 * 2106. 摘水果
 * https://leetcode.cn/problems/maximum-fruits-harvested-after-at-most-k-steps/
 */
public class MaxTotalFruits {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int max = 0;
        for (int i = 0, j = 0, sum = 0; i < fruits.length; sum -= fruits[i++][1]) {
            while (j < fruits.length && 2 * Math.max(startPos - fruits[i][0], 0) + Math.max(fruits[j][0] - startPos, 0) <= k) {
                max = Math.max(max, sum += fruits[j++][1]);
            }
        }
        for (int i = 0, j = 0, sum = 0; i < fruits.length; sum -= fruits[i++][1]) {
            while (j < fruits.length && Math.max(startPos - fruits[i][0], 0) + 2 * Math.max(fruits[j][0] - startPos, 0) <= k) {
                max = Math.max(max, sum += fruits[j++][1]);
            }
        }
        return max;
    }
}
