package leetcode.problem;

/**
 * 1271. 十六进制魔术数字
 * https://leetcode-cn.com/problems/hexspeak/
 */
public class ToHexspeak {
    public String toHexspeak(String num) {
        StringBuffer sb = new StringBuffer();
        long n = Long.parseLong(num);
        while (n > 0) {
            switch ((int) (n % 16)) {
                case 10:
                    sb.append('A');
                    break;
                case 11:
                    sb.append('B');
                    break;
                case 12:
                    sb.append('C');
                    break;
                case 13:
                    sb.append('D');
                    break;
                case 14:
                    sb.append('E');
                    break;
                case 15:
                    sb.append('F');
                    break;
                case 1:
                    sb.append('I');
                    break;
                case 0:
                    sb.append('O');
                    break;
                default:
                    return "ERROR";
            }
            n /= 16;
        }
        return sb.reverse().toString();
    }
}
