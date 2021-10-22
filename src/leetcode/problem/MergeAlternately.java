package leetcode.problem;

/**
 * 1768. 交替合并字符串
 * https://leetcode-cn.com/problems/merge-strings-alternately/
 */
public class MergeAlternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (i = 0; i < word1.length() && i < word2.length(); i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        while (i < word1.length()) {
            sb.append(word1.charAt(i));
            i++;
        }
        while (i < word2.length()) {
            sb.append(word2.charAt(i));
            i++;
        }
        return sb.toString();
    }
}
