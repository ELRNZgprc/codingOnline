package leetcode.problem;

/**
 * 154. 寻找旋转排序数组中的最小值 II
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class FindMin {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == nums[right]) {
                right--;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
        }

        return nums[left];
    }
}
