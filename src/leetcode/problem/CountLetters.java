package leetcode.problem;

/**
 * 1180. 统计只含单一字母的子串
 * https://leetcode-cn.com/problems/count-substrings-with-only-one-distinct-letter/
 */
public class CountLetters {
    public int countLetters(String s) {
        int count = 1;
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                ans += (1 + count) * count / 2;
                count = 1;
            } else {
                count++;
            }
        }
        ans += (1 + count) * count / 2;
        return ans;
    }
}
