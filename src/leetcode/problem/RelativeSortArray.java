package leetcode.problem;

public class RelativeSortArray {
    /**
     * 1122. 数组的相对排序
     * https://leetcode-cn.com/problems/relative-sort-array/
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] hash = new int[1001];
        int[] ans = new int[arr1.length];
        int ansLength = 0;
        for (int i = 0; i < arr1.length; i++) {
            hash[arr1[i]]++;
        }
        for (int a : arr2) {
            while (hash[a] > 0) {
                ans[ansLength] = a;
                ansLength++;
                hash[a]--;
            }
        }
        for (int a = 0; a < 1001; a++) {
            while (hash[a] > 0) {
                ans[ansLength] = a;
                ansLength++;
                hash[a]--;
            }
        }
        return ans;
    }
}
