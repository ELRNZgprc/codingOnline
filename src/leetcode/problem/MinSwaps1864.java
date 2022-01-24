package leetcode.problem;

/**
 * 1864. 构成交替字符串需要的最小交换次数
 * https://leetcode-cn.com/problems/minimum-number-of-swaps-to-make-the-binary-string-alternating/
 */
public class MinSwaps1864 {
    public int minSwaps(String s) {
        int[][] count = new int[2][2];
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            count[c[i] - '0'][i % 2]++;
        }
        if (Math.abs(count[1][0] + count[1][1] - count[0][0] - count[0][1]) > 1) {
            return -1;
        } else if (count[1][0] + count[1][1] - count[0][0] - count[0][1] > 0) {
            return count[1][1];
        } else if (count[1][0] + count[1][1] - count[0][0] - count[0][1] < 0) {
            return count[0][1];
        }
        return Math.min(count[1][0], count[1][1]);
    }
}
