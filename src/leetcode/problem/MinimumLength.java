package leetcode.problem;

/**
 * 1750. 删除字符串两端相同字符后的最短长度
 * https://leetcode.cn/problems/minimum-length-of-string-after-deleting-similar-ends/
 */
public class MinimumLength {
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;
        int res = s.length();
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            char cur = s.charAt(left);
            while (cur == s.charAt(left) && left < right) {
                left++;
                res -= 1;
            }
            while (cur == s.charAt(right) && left <= right) {
                right--;
                res -= 1;
            }
        }
        return res;
    }
}
