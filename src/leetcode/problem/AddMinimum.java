package leetcode.problem;

/**
 * 2645. 构造有效字符串的最少插入数
 * https://leetcode.cn/problems/minimum-additions-to-make-valid-string/
 */
public class AddMinimum {
    public int addMinimum(String word) {
        int n = word.length();
        int[] d = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            d[i] = d[i - 1] + 2;
            if (i > 1 && word.charAt(i - 1) > word.charAt(i - 2)) {
                d[i] = d[i - 1] - 1;
            }
        }
        return d[n];
    }
}
