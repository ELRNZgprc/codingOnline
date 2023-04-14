package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 1023. 驼峰式匹配
 * https://leetcode.cn/problems/camelcase-matching/
 */
public class CamelMatch {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        for (String s : queries) {
            ans.add(check(s, pattern));
        }
        return ans;
    }

    boolean check(String s1, String s2) {
        int index = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (index < s2.length() && s1.charAt(i) == s2.charAt(index)) {
                index++;
            } else if (s1.charAt(i) >= 'A' && s1.charAt(i) <= 'Z') {
                return false;
            }
        }
        return index == s2.length();
    }
}
