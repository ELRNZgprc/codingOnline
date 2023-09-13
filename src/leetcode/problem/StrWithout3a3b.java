package leetcode.problem;

/**
 * 984. 不含 AAA 或 BBB 的字符串
 * https://leetcode.cn/problems/string-without-aaa-or-bbb/
 */
public class StrWithout3a3b {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        while (a > 0 && b > 0) {
            if (a > b) {
                sb.append("aab");
                a -= 2;
                b -= 1;
            } else if (a == b) {
                for (int i = 0; i < a; i++) {
                    sb.append("ab");
                }
                a = 0;
                b = 0;
            } else {
                sb.append("bba");
                a -= 1;
                b -= 2;
            }
        }
        if (a == 0) {
            for (int i = 0; i < b; i++) {
                sb.append("b");
            }
        } else {
            for (int i = 0; i < a; i++) {
                sb.append("a");
            }
        }
        return sb.toString();
    }
}
