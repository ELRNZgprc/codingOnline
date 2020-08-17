package leetcode.problem;

import java.util.Arrays;

public class largestMultipleOfThree {
    /**
     * 1363
     * https://leetcode-cn.com/problems/largest-multiple-of-three/
     */
    public String largestMultipleOfThree(int[] digits) {
        if (digits.length == 0) return "";
        Arrays.sort(digits);
        if (digits[digits.length - 1] == 0) {
            return "0";
        }
        int sum = 0;
        boolean[] flag = new boolean[digits.length];
        for (int i = 0; i < digits.length; i++) {
            sum += digits[i];
            flag[i] = true;
        }
        if (sum % 3 == 1) {
            int i = 0;
            while ((sum % 3 != 0) && (i < digits.length)) {
                if (digits[i] % 3 == 1) {
                    sum -= digits[i];
                    flag[i] = false;
                }
                i++;
            }
            i = 0;
            while ((sum % 3 != 0) && (i < digits.length)) {
                if (digits[i] % 3 == 2) {
                    sum -= digits[i];
                    flag[i] = false;
                }
                i++;
            }
        }
        if (sum % 3 == 2) {
            int i = 0;
            while ((sum % 3 != 0) && (i < digits.length)) {
                if (digits[i] % 3 == 2) {
                    sum -= digits[i];
                    flag[i] = false;
                }
                i++;
            }
            i = 0;
            while ((sum % 3 != 0) && (i < digits.length)) {
                if (digits[i] % 3 == 1) {
                    sum -= digits[i];
                    flag[i] = false;
                }
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = digits.length - 1; i >= 0; i--) {
            if (flag[i]) {
                sb.append(digits[i]);
            }
        }
        return sb.toString();
    }

}
