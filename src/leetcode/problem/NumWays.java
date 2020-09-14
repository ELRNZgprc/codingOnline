package leetcode.problem;

public class NumWays {
    /**
     * 1573. 分割字符串的方案数
     * https://leetcode-cn.com/problems/number-of-ways-to-split-a-string/
     */
    public int numWays(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        if (count % 3 != 0) {
            return 0;
        }
        if (count == 0) {
            return (int) ((long) (s.length() - 1) * (long) (s.length() - 2) / 2 % 1000000007);
        }
        count /= 3;
        long ans = 1;
        int number0 = 0;
        int number1 = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                number0++;
            } else {
                if ((number1 > 0) && (number1 % count == 0)) {
                    ans = (ans * (number0 + 1)) % (1000000007);
                }
                number0 = 0;
                number1++;
            }
        }
        return (int) ans;
    }
}
