package leetcode.problem;

/**
 * 1056. 易混淆数
 * https://leetcode-cn.com/problems/confusing-number/
 */
public class ConfusingNumber {
    public boolean confusingNumber(int N) {
        char[] ns = String.valueOf(N).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : ns) {
            if ((c == '2') || (c == '3') || (c == '4') || (c == '5') || (c == '7')) {
                return false;
            }
            if (c == '6') {
                sb.append('9');
            } else if (c == '9') {
                sb.append('6');
            } else {
                sb.append(c);
            }
        }
        return !sb.reverse().toString().equals(String.valueOf(N));
    }
}
