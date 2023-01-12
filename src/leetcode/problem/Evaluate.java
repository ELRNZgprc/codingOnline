package leetcode.problem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1807. 替换字符串中的括号内容
 * https://leetcode.cn/problems/evaluate-the-bracket-pairs-of-a-string/
 */
public class Evaluate {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            char a = s.charAt(index);
            if (a == '(') {
                StringBuilder sb1 = new StringBuilder();
                index++;
                while (s.charAt(index) != ')') {
                    sb1.append(s.charAt(index));
                    index++;
                }
                if (map.containsKey(sb1.toString())) {
                    sb.append(map.get(sb1.toString()));
                } else {
                    sb.append('?');
                }
            } else {
                sb.append(a);
            }
            index++;
        }
        return sb.toString();
    }
}
