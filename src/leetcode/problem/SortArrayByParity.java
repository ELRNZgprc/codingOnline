package leetcode.problem;

public class SortArrayByParity {
    /**
     * 905. 按奇偶排序数组
     * https://leetcode-cn.com/problems/sort-array-by-parity/
     */
    public int[] sortArrayByParity(int[] A) {
        if (A.length <= 1) {
            return A;
        }
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            if ((A[left] % 2 == 1) && (A[right] % 2 == 0)) {
                int t = A[left];
                A[left] = A[right];
                A[right] = t;
            }
            while ((left < A.length) && (A[left] % 2 == 0)) {
                left++;
            }
            while ((right > -1) && (A[right] % 2 == 1)) {
                right--;
            }
        }
        return A;
    }
}
