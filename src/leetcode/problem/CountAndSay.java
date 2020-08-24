package leetcode.problem;

public class CountAndSay {
    /**
     * 38. 外观数列
     * https://leetcode-cn.com/problems/count-and-say/
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String temp = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        char c = '0';
        int count = 0;
        for (int x = 0; x < temp.length(); x++) {
            if (x == 0) {
                c = temp.charAt(x);
                count = 1;
            } else {
                if (temp.charAt(x) == c) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(c);
                    c = temp.charAt(x);
                    count = 1;
                }
            }
        }
        sb.append(count);
        sb.append(c);
        return sb.toString();
    }
}
