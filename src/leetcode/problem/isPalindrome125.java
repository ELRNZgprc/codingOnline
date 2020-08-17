package leetcode.problem;

public class isPalindrome125 {
    /**
     * 125
     * https://leetcode-cn.com/problems/valid-palindrome/
     */
    public boolean isPalindrome(String s) {
        if (s.equals("")) return true;
        s = s.toLowerCase();
        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (((s.charAt(i) <= '9') && (s.charAt(i) >= '0')) || ((s.charAt(i) <= 'z') && ((s.charAt(i) >= 'a')))) {
                s1.append(s.charAt(i));
            }
        }
        return s1.toString().equals(s1.reverse().toString());
    }
}
