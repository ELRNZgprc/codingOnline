package leetcode.problem;

public class FirstUniqChar {
    /**
     * 387. 字符串中的第一个唯一字符
     * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
     */
    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (s.indexOf(ch) == s.lastIndexOf(ch)) {
                return i;
            }
        }
        return -1;
    }
}
