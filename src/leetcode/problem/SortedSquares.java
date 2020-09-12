package leetcode.problem;

import java.util.Arrays;

public class SortedSquares {
    /**
     * 977. 有序数组的平方
     * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
     */
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }
}
