package leetcode.problem;

public class findMedianSortedArrays {
    /**
     * 4
     * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];

        int a = 0;
        int b = 0;
        int length = 0;
        while ((a < nums1.length) || (b < nums2.length)) {
            if (a >= nums1.length) {
                nums[length++] = nums2[b++];
            } else if (b >= nums2.length) {
                nums[length++] = nums1[a++];
            } else {
                nums[length++] = (nums1[a] < nums2[b]) ? nums1[a++] : nums2[b++];
            }
        }
        return (length % 2 == 1) ? nums[(length - 1) / 2] : ((nums[length / 2] + nums[length / 2 - 1]) / 2.0);
    }
}
