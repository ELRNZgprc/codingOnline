package leetcode.problem;

public class multiply {
    /**
     * 43
     * https://leetcode-cn.com/problems/multiply-strings/
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int n = num1.length();
        int m = num2.length();
        int[] multi = new int[n + m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                multi[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        for (int i = n + m - 1; i > 0; i--) {
            if (multi[i] >= 10) {
                multi[i - 1] += multi[i] / 10;
                multi[i] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (multi[i] == 0) {
            i++;
        }
        while (i < n + m) {
            sb.append(multi[i]);
            i++;
        }
        return sb.toString();
    }
}
