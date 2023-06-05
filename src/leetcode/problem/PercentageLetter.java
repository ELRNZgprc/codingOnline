package leetcode.problem;

/**
 * 2278. 字母在字符串中的百分比
 * https://leetcode.cn/problems/percentage-of-letter-in-string/
 */
public class PercentageLetter {
    public int percentageLetter(String s, char letter) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == letter) {
                count++;
            }
        }
        return count * 100 / s.length();
    }
}
