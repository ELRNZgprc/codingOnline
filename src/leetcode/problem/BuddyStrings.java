package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 859. 亲密字符串
 * https://leetcode-cn.com/problems/buddy-strings/
 */
public class BuddyStrings {
    public boolean buddyStrings(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        if (a.equals(b)) {
            boolean[] hash = new boolean[26];
            for (char c : a.toCharArray()) {
                if (hash[c - 'a']) {
                    return true;
                }
                hash[c - 'a'] = true;
            }
            return false;
        }
        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff.add(i);
                if (diff.size() > 2) {
                    return false;
                }
            }
        }
        if (diff.size() != 2) {
            return false;
        }
        return (a.charAt(diff.get(0)) == b.charAt(diff.get(1))) && (a.charAt(diff.get(1)) == b.charAt(diff.get(0)));
    }
}
