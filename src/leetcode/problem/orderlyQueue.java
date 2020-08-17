package leetcode.problem;

import java.util.Arrays;

public class orderlyQueue {
    /**
     * 899
     * https://leetcode-cn.com/problems/orderly-queue/
     */
    public String orderlyQueue(String S, int K) {
        if (K > 1) {
            char[] chars = S.toCharArray();
            Arrays.sort(chars);
            StringBuilder sb = new StringBuilder();
            for (char c : chars) {
                sb.append(c);
            }
            return sb.toString();
        }
        String ss = S + S;
        String ans = S;
        for (int i = 0; i < S.length(); i++) {
            if (ans.compareTo(ss.substring(i, i + S.length())) > 0) {
                ans = ss.substring(i, i + S.length());
            }
        }
        return ans;
    }
}
