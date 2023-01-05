package leetcode.problem;

/**
 * 1031. 两个非重叠子数组的最大和
 * https://leetcode.cn/problems/maximum-sum-of-two-non-overlapping-subarrays/
 */
public class MaxSumTwoNoOverlap {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int len = A.length, dpL[] = new int[len - L + 1], dpM[] = new int[len - M + 1], max = 0;
        for (int i = 0; i < L; i++)
            dpL[0] += A[i];
        for (int i = 0; i < M; i++)
            dpM[0] += A[i];
        for (int i = 1; i < len - L + 1; i++)
            dpL[i] = dpL[i - 1] + A[i + L - 1] - A[i - 1];
        for (int i = 1; i < len - M + 1; i++)
            dpM[i] = dpM[i - 1] + A[i + M - 1] - A[i - 1];
        for (int i = 0; i < len - L - M + 1; i++) {
            int count = len - i - L - M;
            while (count >= 0) {
                max = Math.max(max, Math.max(dpL[i] + dpM[i + L + count], dpM[i] + dpL[i + M + count]));
                count--;
            }
        }
        return max;
    }
}
