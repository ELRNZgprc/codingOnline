package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 1940. 排序数组之间的最长公共子序列
 * https://leetcode.cn/problems/longest-common-subsequence-between-sorted-arrays/
 */
public class LongestCommonSubsequence1940 {
    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        int n = arrays.length;
        int[] f = new int[101];
        for (int[] a : arrays)
            for (int x : a) {
                f[x]++;
            }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= 100; i++)
            if (f[i] == n) {
                ans.add(i);
            }
        return ans;
    }
}
