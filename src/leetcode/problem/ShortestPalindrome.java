package leetcode.problem;

public class ShortestPalindrome {
    /**
     * 214. 最短回文串
     * https://leetcode-cn.com/problems/shortest-palindrome/
     */
    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        String revS = sb.reverse().toString();
        int len = s.length();
        for (int i = len; i >= 0; i--) {
            if (s.substring(0, i).equals(revS.substring(len - i, len))) {
                return revS.substring(0, len - i) + s;
            }
        }
        return revS + s;
    }
}
