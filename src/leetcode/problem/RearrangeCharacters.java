package leetcode.problem;

/**
 * 2287. 重排字符形成目标字符串
 * https://leetcode.cn/problems/rearrange-characters-to-make-target-string/
 */
public class RearrangeCharacters {
    public int rearrangeCharacters(String s, String target) {
        int[] count = new int[26];
        int[] need = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : target.toCharArray()) {
            need[c - 'a']++;
        }
        int ans = s.length() / target.length();
        for (int i = 0; i < 26; i++) {
            if (need[i] > 0) {
                ans = Math.min(ans, count[i] / need[i]);
            }
        }
        return ans;
    }
}
