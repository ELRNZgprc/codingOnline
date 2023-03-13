package leetcode.problem;

/**
 * 2399. 检查相同字母间的距离
 * https://leetcode.cn/problems/check-distances-between-same-letters/
 */
public class CheckDistances {
    public boolean checkDistances(String s, int[] distance) {
        int[] hash = new int[26];
        int[] ans = new int[26];
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (hash[c[i] - 'a'] == 0) {
                hash[c[i] - 'a'] = i + 1;
            } else {
                ans[c[i] - 'a'] = i - hash[c[i] - 'a'];
            }
        }
        for (int i = 0; i < 26; i++) {
            if (hash[i] != 0) {
                if (ans[i] != distance[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
