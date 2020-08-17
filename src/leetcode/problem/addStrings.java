package leetcode.problem;

public class addStrings {
    /**
     * 415
     * https://leetcode-cn.com/problems/add-strings/
     */
    public String addStrings(String num1, String num2) {
        StringBuilder ans = new StringBuilder();
        int target = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while ((target != 0) || (i >= 0) || (j >= 0)) {
            if (i >= 0) {
                target += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                target += num2.charAt(j--) - '0';
            }
            ans.append(target % 10);
            target /= 10;
        }
        return ans.reverse().toString();
    }
}
