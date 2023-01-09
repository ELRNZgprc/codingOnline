package leetcode.problem;

import java.util.Arrays;

/**
 * 1806. 还原排列的最少操作步数
 * https://leetcode.cn/problems/minimum-number-of-operations-to-reinitialize-a-permutation/
 */
public class ReinitializePermutation {
    public int reinitializePermutation(int n) {
        int[] perm = new int[n];
        int[] originalPerm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }
        originalPerm = perm;
        int count = 0;

        while (true) {
            int[] array = new int[n];
            for (int i = 0; i < perm.length; i++) {
                if (i % 2 == 0) {
                    array[i] = perm[i / 2];
                } else {
                    array[i] = perm[n / 2 + (i - 1) / 2];
                }
            }
            count++;
            if (Arrays.equals(array, originalPerm)) break;
            perm = array;
        }
        return count;
    }
}
