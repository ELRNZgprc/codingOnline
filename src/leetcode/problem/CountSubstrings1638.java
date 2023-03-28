package leetcode.problem;

/**
 * 1638. 统计只差一个字符的子串数目
 * https://leetcode.cn/problems/count-substrings-that-differ-by-one-character/
 */
public class CountSubstrings1638 {
    public int countSubstrings(String s, String t) {
        int m = s.length(), n = t.length();
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int diff = 0;
                for (int k = 0; i + k < m && j + k < n; ++k) {
                    if (s.charAt(i + k) != t.charAt(j + k)) diff++;
                    if (diff == 1) ans++;
                    else if (diff > 1) break;
                }
            }
        }
        return ans;
    }
}
