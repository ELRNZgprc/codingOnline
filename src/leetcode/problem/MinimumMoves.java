package leetcode.problem;

/**
 * 2027. 转换字符串的最少操作次数
 * https://leetcode-cn.com/problems/minimum-moves-to-convert-string/
 */
public class MinimumMoves {
    public int minimumMoves(String s) {
        int ans = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == 'X') {
                ans++;
                i += 3;
            } else {
                i++;
            }
        }
        return ans;
    }
}
