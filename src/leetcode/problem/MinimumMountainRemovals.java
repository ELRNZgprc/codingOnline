package leetcode.problem;

/**
 * 1671. 得到山形数组的最少删除次数
 * https://leetcode.cn/problems/minimum-number-of-removals-to-make-mountain-array/
 */
public class MinimumMountainRemovals {
    public int minimumMountainRemovals(int[] nums) {
        int length = nums.length;
        int[] pre = new int[length];
        int[] next = new int[length];
        for (int i = 1; i < length - 1; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    pre[i] = Math.max(pre[i], pre[j] + 1);
                }
            }
        }
        for (int i = length - 2; i > 0; i--) {
            for (int j = length - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    next[i] = Math.max(next[i], next[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < length; i++) {
            if (pre[i] > 0 && (next[i] > 0)) {
                res = Math.max(res, pre[i] + next[i] + 1);
            }
        }
        return length - res;
    }
}
