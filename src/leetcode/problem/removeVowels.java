package leetcode.problem;

public class removeVowels {
    /**
     * 1119
     * https://leetcode-cn.com/problems/remove-vowels-from-a-string/
     */
    public String removeVowels(String S) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if ((S.charAt(i) != 'a') && (S.charAt(i) != 'e') && (S.charAt(i) != 'o') && (S.charAt(i) != 'i') && (S.charAt(i) != 'u')) {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }
}
