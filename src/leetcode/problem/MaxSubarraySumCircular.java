package leetcode.problem;

/**
 * 918. 环形子数组的最大和
 * https://leetcode.cn/problems/maximum-sum-circular-subarray/
 */
public class MaxSubarraySumCircular {
    public int maxSubarraySumCircular(int[] A) {
        if (A == null || A.length < 1) {
            return 0;
        }
        int curMax, max, curMin, min, sum;
        curMax = max = curMin = min = sum = A[0];
        for (int i = 1; i < A.length; i++) {
            sum += A[i];
            curMax = curMax > 0 ? curMax + A[i] : A[i];
            max = Math.max(curMax, max);
            curMin = curMin < 0 ? curMin + A[i] : A[i];
            min = Math.min(curMin, min);
        }
        if (max < 0)
            return max;
        return Math.max(sum - min, max);
    }
}
