package leetcode.problem;

public class ToLowerCase {
    /**
     * 709. 转换成小写字母
     * https://leetcode-cn.com/problems/to-lower-case/
     */
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if ((c >= 'A') && (c <= 'Z')) {
                sb.append((char) (c + 'a' - 'A'));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
