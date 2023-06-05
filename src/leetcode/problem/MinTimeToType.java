package leetcode.problem;

/**
 * 1974. 使用特殊打字机键入单词的最少时间
 * https://leetcode.cn/problems/minimum-time-to-type-word-using-special-typewriter/
 */
public class MinTimeToType {
    public int minTimeToType(String word) {
        int ans = 0;
        char c = 'a';
        for (char w : word.toCharArray()) {
            ans += Math.min(Math.abs(w - c), 26 - Math.abs(w - c)) + 1;
            c = w;
        }
        return ans;
    }
}
