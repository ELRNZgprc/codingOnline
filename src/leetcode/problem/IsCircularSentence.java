package leetcode.problem;

/**
 * 2490. 回环句
 * https://leetcode.cn/problems/circular-sentence/
 */
public class IsCircularSentence {
    public boolean isCircularSentence(String sentence) {
        String[] s = sentence.split(" ");
        int n = s.length;
        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            if (s[i].charAt(s[i].length() - 1) != s[j].charAt(0)) return false;
        }
        return true;
    }
}
