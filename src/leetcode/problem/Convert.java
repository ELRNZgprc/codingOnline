package leetcode.problem;

/**
 * 6. Z 字形变换
 * https://leetcode-cn.com/problems/zigzag-conversion/
 */
public class Convert {
    public String convert(String s, int numRows) {
        String[] str = new String[numRows];
        for (int i = 0; i < numRows; i++) str[i] = "";
        int p = 0, n = s.length();
        while (p < n) {
            for (int i = 0; i < numRows && p < n; i++) str[i] += s.charAt(p++);
            for (int i = numRows - 2; i >= 1 && p < n; i--) str[i] += s.charAt(p++);
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            ans.append(str[i]);
        }
        return ans.toString();
    }
}
