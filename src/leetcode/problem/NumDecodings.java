package leetcode.problem;

/**
 * 91. 解码方法
 * https://leetcode-cn.com/problems/decode-ways/
 */
public class NumDecodings {
    public int numDecodings(String s) {
        int n = s.length();
        int[] nums = new int[n + 1];
        nums[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0')
                nums[i] += nums[i - 1];
            if (i > 1 && s.charAt(i - 2) != '0' && (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)
                nums[i] += nums[i - 2];
        }
        return nums[n];
    }
}
