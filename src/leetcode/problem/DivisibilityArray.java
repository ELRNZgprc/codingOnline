package leetcode.problem;

/**
 * 2575. 找出字符串的可整除数组
 * https://leetcode.cn/problems/find-the-divisibility-array-of-a-string/
 */
public class DivisibilityArray {
    public int[] divisibilityArray(String word, int m) {
        int len = word.length();
        int[] ans = new int[len];
        long remainder = 0;
        for (int i = 0; i < len; i++) {
            remainder = (remainder * 10 + word.charAt(i) - '0') % m;
            ans[i] = remainder == 0 ? 1 : 0;
        }
        return ans;
    }
}
