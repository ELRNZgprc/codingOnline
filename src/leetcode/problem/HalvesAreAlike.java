package leetcode.problem;

import java.util.Collections;
import java.util.HashSet;

/**
 * 1704. 判断字符串的两半是否相似
 * https://leetcode.cn/problems/determine-if-string-halves-are-alike/
 */
public class HalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        HashSet<Character> set = new HashSet<>();
        Collections.addAll(set, 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int left = 0;
        int right = 0;
        int n = s.length() / 2;
        for (int i = 0; i < n; i++) {
            if (set.contains(s.charAt(i))) {
                left++;
            }
            if (set.contains(s.charAt(i + n))) {
                right++;
            }
        }
        return left == right;
    }
}
