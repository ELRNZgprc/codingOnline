package leetcode.problem;

import java.util.Arrays;

/**
 * 1929. 数组串联
 * https://leetcode.cn/problems/concatenation-of-array/
 */
public class GetConcatenation {
    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int[] ans = Arrays.copyOf(nums, len << 1);
        System.arraycopy(nums, 0, ans, len, len);
        System.gc();
        return ans;
    }
}
