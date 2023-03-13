package leetcode.problem;

/**
 * 1844. 将所有数字用字符替换
 * https://leetcode.cn/problems/replace-all-digits-with-characters/
 */
public class ReplaceDigits {
    public String replaceDigits(String s) {
        char[] sa = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        char cc = sa[0];
        for (char c : sa) {
            if (('a' <= c) && (c <= 'z')) {
                cc = c;
                sb.append(c);
            } else {
                sb.append((char) (cc + c - '0'));
            }
        }
        return sb.toString();
    }
}
