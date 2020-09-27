package leetcode.problem;

public class Search {
	/**
	 * 33. 搜索旋转排序数组
	 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
	 */
	public int search(int[] nums, int target) {
		int begin = 0;
		int end = nums.length - 1;
		while (begin <= end) {
			if (nums[begin] == target) {
				return begin;
			}
			if (nums[end] == target) {
				return end;
			}
			int mid = begin + (end - begin) / 2;
			if (nums[mid] == target) {
				return mid;
			} else {
				if (nums[mid] < nums[end]) {
					if ((nums[mid] < target) && (target <= nums[end]))
						begin = mid + 1;
					else
						end = mid - 1;
				} else {
					if ((nums[begin] <= target) && (target < nums[mid]))
						end = mid - 1;
					else
						begin = mid + 1;
				}
			}
		}
		return -1;
	}
}
