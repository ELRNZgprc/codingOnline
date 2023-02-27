package leetcode.problem;

/**
 * 1144. 递减元素使数组呈锯齿状
 * https://leetcode.cn/problems/decrease-elements-to-make-array-zigzag/
 */
public class MovesToMakeZigzag {
    public int movesToMakeZigzag(int[] nums) {
        int a1 = 0, a2 = 0;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            int t1 = Integer.MAX_VALUE, t2 = Integer.MAX_VALUE;
            if (i - 1 >= 0) t1 = nums[i - 1];
            if (i + 1 < n) t2 = nums[i + 1];
            if (nums[i] >= t1 || nums[i] >= t2) {
                if (i % 2 == 0) {
                    a1 += nums[i] - Math.min(t1, t2) + 1;
                } else {
                    a2 += nums[i] - Math.min(t1, t2) + 1;
                }
            }
        }
        return Math.min(a1, a2);
    }
}
