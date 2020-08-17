package leetcode.problem;

public class isPalindrome {
    /**
     * 9
     * https://leetcode-cn.com/problems/palindrome-number/
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int y = x;
        int target = 0;

        while (y > 0) {
            int i = y % 10;
            target = target * 10 + i;
            y /= 10;
        }
        return (target == x);
    }
}
