package leetcode.mst;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 01.04. 回文排列
 * https://leetcode.cn/problems/palindrome-permutation-lcci/
 */
public class CanPermutePalindrome {
    public boolean canPermutePalindrome(String s) {
        if (s.length() == 0) {
            return false;
        }
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.size() <= 1;
    }
}
