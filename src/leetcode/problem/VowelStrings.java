package leetcode.problem;

/**
 * 2559. 统计范围内的元音字符串数
 * https://leetcode.cn/problems/count-vowel-strings-in-ranges/
 */
public class VowelStrings {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] count = new int[words.length + 1];
        for (int i = 1; i < count.length; i++) {
            String word = words[i - 1];
            if (((isVowel(word.charAt(0))) && (isVowel(word.charAt(word.length() - 1))))) {
                count[i] = count[i - 1] + 1;
            } else {
                count[i] = count[i - 1];
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = count[queries[i][1] + 1] - count[queries[i][0]];
        }
        return res;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
