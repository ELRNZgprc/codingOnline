package leetcode.problem;

public class CustomSortString {
    /**
     * 791. 自定义字符串排序
     * https://leetcode-cn.com/problems/custom-sort-string/
     */
    public String customSortString(String S, String T) {
        int[] record = new int[26];
        for (int i = 0; i < T.length(); i++) {
            record[T.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            while (record[S.charAt(i) - 'a'] > 0) {
                sb.append(S.charAt(i));
                record[S.charAt(i) - 'a']--;
            }
        }
        for (int i = 0; i < 26; i++) {
            while (record[i] > 0) {
                sb.append((char) (i + 'a'));
                record[i]--;
            }
        }
        return sb.toString();
    }
}
