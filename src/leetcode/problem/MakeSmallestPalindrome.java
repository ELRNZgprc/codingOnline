package leetcode.problem;

/**
 * 2697. 字典序最小回文串
 * https://leetcode.cn/problems/lexicographically-smallest-palindrome/
 */
public class MakeSmallestPalindrome {
    public String makeSmallestPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] c = s.toCharArray();
        while (left < right) {
            if (c[left] != c[right]) {
                c[left] = c[right] = c[left] < c[right] ? c[left] : c[right];
            }
            left++;
            right--;
        }
        return String.valueOf(c);
    }
}
