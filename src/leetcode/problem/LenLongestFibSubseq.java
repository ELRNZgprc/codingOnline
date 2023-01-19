package leetcode.problem;

import java.util.Arrays;

/**
 * 873. 最长的斐波那契子序列的长度
 * https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence/
 */
public class LenLongestFibSubseq {
    public int lenLongestFibSubseq(int[] A) {
        int max = 2;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int tmpI = A[i];
                int tmpJ = A[j];
                int sum = tmpI + tmpJ;
                int cur = 2;
                //存在
                while (Arrays.binarySearch(A, sum) >= 0) {
                    tmpI = tmpJ;
                    tmpJ = sum;
                    sum = tmpI + tmpJ;
                    cur++;
                }
                max = Math.max(max, cur);
            }
        }
        return max < 3 ? 0 : max;
    }
}
