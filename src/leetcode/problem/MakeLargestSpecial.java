package leetcode.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 761. 特殊的二进制序列
 * https://leetcode.cn/problems/special-binary-string/
 */
public class MakeLargestSpecial {
    public String makeLargestSpecial(String s) {
        int count = 0, pre = 0, n = s.length();
        if (n == 0) {
            return "";
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '1') {
                count++;
            } else {
                count--;
                if (count == 0) {
                    list.add("1" + makeLargestSpecial(s.substring(pre + 1, i)) + "0");
                    pre = i + 1;
                }
            }
        }
        Collections.sort(list);
        StringBuilder ans = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            ans.append(list.get(i));
        }
        return ans.toString();
    }
}
