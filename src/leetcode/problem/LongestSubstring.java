package leetcode.problem;

/**
 * 395. 至少有 K 个重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
 */
public class LongestSubstring {
    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        int[] cnt = new int[26];
        int n = str.length;
        if (n < k)
            return 0;
        for (char c : str) {//统计字母出现的次数
            cnt[c - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (cnt[str[i] - 'a'] < k) {
                int l = longestSubstring(s.substring(0, i), k);//左分治
                int r = longestSubstring(s.substring(i + 1, n), k);//右分治
                return Math.max(l, r);
            }
        }
        return n;
    }
}
