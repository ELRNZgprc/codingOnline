package leetcode.problem;

/**
 * 1663. 具有给定数值的最小字符串
 * https://leetcode-cn.com/problems/smallest-string-with-a-given-numeric-value/
 */
public class GetSmallestString {
    public String getSmallestString(int n, int k) {
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i]++;
            k--;
        }
        int i = n - 1;
        while (k > 0) {
            ans[i] += Math.min(k, 25);
            k -= (ans[i] - 1);
            i--;
        }
        StringBuilder sb = new StringBuilder();
        for (int a : ans) {
            sb.append((char) (a + 'a' - 1));
        }
        return sb.toString();
    }
}
