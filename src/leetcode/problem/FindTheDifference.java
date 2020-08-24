package leetcode.problem;

public class FindTheDifference {
    /**
     * 389. 找不同
     * https://leetcode-cn.com/problems/find-the-difference/
     */
    public char findTheDifference(String s, String t) {
        int[] hash = new int[26];
        for (char c : s.toCharArray()) {
            hash[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (hash[c - 'a'] == 0) {
                return c;
            }
            hash[c - 'a']--;
        }
        return ' ';
    }
}
