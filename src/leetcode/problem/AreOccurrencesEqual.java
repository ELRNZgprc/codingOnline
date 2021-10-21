package leetcode.problem;

/**
 * 1941. 检查是否所有字符出现次数相同
 * https://leetcode-cn.com/problems/check-if-all-characters-have-equal-number-of-occurrences/
 */
public class AreOccurrencesEqual {
    public boolean areOccurrencesEqual(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int flag = 0;
        while (count[flag] == 0) {
            flag++;
        }
        for (int i = flag + 1; i < 26; i++) {
            if ((count[i] != 0) && (count[i] != count[flag])) {
                return false;
            }
        }
        return true;
    }
}
