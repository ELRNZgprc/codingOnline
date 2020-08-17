package leetcode.problem;

public class removeDuplicates {
    /**
     * 1047
     * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
     */
    public String removeDuplicates(String S) {
        if (S.length() <= 1) {
            return S;
        }
        boolean[] flag = new boolean[S.length()];
        for (int i = 0; i < S.length(); i++) {
            flag[i] = true;
        }
        for (int i = 0; i < S.length() - 1; i++) {
            if (flag[i]) {
                int j = i + 1;
                while (j < S.length() && !flag[j]) {
                    j++;
                }
                if (j < S.length() && (S.charAt(i) == S.charAt(j))) {
                    flag[i] = false;
                    flag[j] = false;
                    i = -1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (flag[i]) {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }
}
