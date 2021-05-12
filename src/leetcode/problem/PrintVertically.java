package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 1324. 竖直打印单词
 * https://leetcode-cn.com/problems/print-words-vertically/
 */
public class PrintVertically {
    public List<String> printVertically(String s) {
        String[] ss = s.split(" ");
        int length = Integer.MIN_VALUE;
        for (String sss : ss) {
            length = Math.max(length, sss.length());
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            StringBuffer sb = new StringBuffer();
            for (String sss : ss) {
                if (i < sss.length()) {
                    sb.append(sss.charAt(i));
                } else {
                    sb.append(' ');
                }
            }
            while (sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}
