package leetcode.problem;

/**
 * 1796. 字符串中第二大的数字
 * https://leetcode.cn/problems/second-largest-digit-in-a-string/
 */
public class SecondHighest {
    public int secondHighest(String s) {
        int highest = -1;
        int second = -1;
        for (char c : s.toCharArray()) {
            if ((c <= '9') && (c >= '0')) {
                int cc = c - '0';
                if (cc > highest) {
                    second = highest;
                    highest = cc;
                } else if ((cc < highest) && (cc > second)) {
                    second = cc;
                }
            }
        }
        return second;
    }
}
