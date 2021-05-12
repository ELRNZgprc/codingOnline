package leetcode.problem;

/**
 * 1310. 子数组异或查询
 * https://leetcode-cn.com/problems/xor-queries-of-a-subarray/
 */
public class XorQueries {
    public int[] xorQueries(int[] arr, int[][] queries) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i] ^ arr[i - 1];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] == 0) {
                ans[i] = arr[queries[i][1]];
            } else {
                ans[i] = arr[queries[i][0] - 1] ^ arr[queries[i][1]];
            }
        }
        return ans;
    }
}
