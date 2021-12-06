package leetcode.problem;

/**
 * 1062. 最长重复子串
 * https://leetcode-cn.com/problems/longest-repeating-substring/
 */
public class LongestRepeatingSubstring {
    public int longestRepeatingSubstring(String s) {
        int ans = 0;
        int length;
        for (int i = 1; i < s.length(); i++) {
            length = 0;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(j - i)) {
                    length++;
                } else {
                    ans = Math.max(ans, length);
                    length = 0;
                }
            }
            ans = Math.max(ans, length);
        }
        return ans;
    }
}
