package leetcode.problem;

public class makeGood {
    /**
     * 1544
     * https://leetcode-cn.com/problems/make-the-string-great/
     */
    public String makeGood(String s) {
        if (s.length() <= 1) {
            return s;
        }
        boolean[] flag = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            flag[i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (flag[i]) {
                int j = i + 1;
                while (j < s.length() && !flag[j]) {
                    j++;
                }
                if (j < s.length() && (Math.abs(s.charAt(i) - s.charAt(j)) == 'a' - 'A')) {
                    flag[i] = false;
                    flag[j] = false;
                    i = -1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (flag[i]) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
