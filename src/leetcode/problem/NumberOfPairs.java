package leetcode.problem;

/**
 * 2341. 数组能形成多少数对
 * https://leetcode.cn/problems/maximum-number-of-pairs-in-array/
 */
public class NumberOfPairs {
    public int[] numberOfPairs(int[] nums) {
        int ans = 0;
        int[] a = new int[101];
        for (int num : nums) {
            if ((a[num] ^= 1) == 0) ans++;
        }
        return new int[]{ans, nums.length - 2 * ans};
    }
}
