package leetcode.problem;

/**
 * 1957. 删除字符使字符串变好
 * https://leetcode-cn.com/problems/delete-characters-to-make-fancy-string/
 */
public class MakeFancyString {
    public String makeFancyString(String s) {
        StringBuffer sb = new StringBuffer();
        int length = 0;
        char pre = 'A';
        for (char c : s.toCharArray()) {
            if ((c != pre) || (length != 2)) {
                sb.append(c);
                length = (c == pre) ? length + 1 : 1;
                pre = c;
            }
        }
        return sb.toString();
    }
}
