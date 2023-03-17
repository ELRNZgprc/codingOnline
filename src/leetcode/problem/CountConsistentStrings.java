package leetcode.problem;

/**
 * 1684. 统计一致字符串的数目
 * https://leetcode.cn/problems/count-the-number-of-consistent-strings/
 */
public class CountConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] hash = new int[26];
        for (char c : allowed.toCharArray()) {
            hash[c - 'a']++;
        }
        int ans = 0;
        for (String word : words) {
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                if (hash[word.charAt(i) - 'a'] == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans++;
            }
        }
        return ans;
    }
}
