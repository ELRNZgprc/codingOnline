package leetcode.problem;

/**
 * 2540. 最小公共值
 * https://leetcode.cn/problems/minimum-common-value/
 */
public class GetCommon {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        while ((i < nums1.length) && (j < nums2.length)) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            }
            if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return -1;
    }
}
