package leetcode.problem;

/**
 * 2299. 强密码检验器 II
 * https://leetcode.cn/problems/strong-password-checker-ii/
 */
public class StrongPasswordCheckerII {
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean number = false;
        boolean upper = false;
        boolean lower = false;
        boolean special = false;
        String specialStr = "!@#$%^&*()-+";
        for (int i = 0; i < password.length(); i++) {
            if (i <= password.length() - 2 && (password.charAt(i) == password.charAt(i + 1))) {
                return false;
            }
            char c = password.charAt(i);
            if (Character.isDigit(c)) {
                number = true;
            }
            if (Character.isUpperCase(c)) {
                upper = true;
            }
            if (Character.isLowerCase(c)) {
                lower = true;
            }
            if (specialStr.indexOf(c) != -1) {
                special = true;
            }
        }
        return number && upper && lower && special;
    }
}
