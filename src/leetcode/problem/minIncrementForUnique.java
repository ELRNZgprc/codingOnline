package leetcode.problem;

import java.util.Arrays;

public class minIncrementForUnique {
    /**
     * 945
     * https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/
     */
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int ans = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                ans += A[i - 1] + 1 - A[i];
                A[i] = A[i - 1] + 1;
            }
        }
        return ans;
    }
}
