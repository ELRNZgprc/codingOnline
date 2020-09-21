package leetcode.problem;

public class CalculateTime {
    /**
     * 1165. 单行键盘
     * https://leetcode-cn.com/problems/single-row-keyboard/
     */
    public int calculateTime(String keyboard, String word) {
        int[] position = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
            position[keyboard.charAt(i) - 'a'] = i;
        }
        int now = 0;
        int ans = 0;
        for (int i = 0; i < word.length(); i++) {
            ans += Math.abs(position[word.charAt(i) - 'a'] - now);
            now = position[word.charAt(i) - 'a'];
        }
        return ans;
    }
}
