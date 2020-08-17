package leetcode.problem;

public class merge88 {
    /**
     * 88
     * https://leetcode-cn.com/problems/merge-sorted-array/
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];

        int a = 0;
        int b = 0;
        int length = 0;
        while ((a < m) || (b < n)) {
            if (a >= m) {
                nums[length++] = nums2[b++];
            } else if (b >= n) {
                nums[length++] = nums1[a++];
            } else {
                nums[length++] = (nums1[a] < nums2[b]) ? nums1[a++] : nums2[b++];
            }
        }

        for (int i = 0; i < m + n; i++) {
            nums1[i] = nums[i];
        }
    }
}
