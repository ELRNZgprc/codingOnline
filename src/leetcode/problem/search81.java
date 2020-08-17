package leetcode.problem;

public class search81 {
    /**
     * 81
     * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
     */
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        if (target >= nums[0]) {
            int i = 0;
            if (nums[i] == target) return true;
            i++;
            while ((i < nums.length) && (nums[i] >= nums[i - 1])) {
                if (nums[i] == target) {
                    return true;
                }
                if (nums[i] > target) {
                    return false;
                }
                i++;
            }
            return false;
        } else {
            int i = 1;
            while ((i < nums.length) && (nums[i] >= nums[i - 1])) {
                i++;
            }
            while (i < nums.length) {
                if (nums[i] == target) {
                    return true;
                }
                if (nums[i] > target) {
                    return false;
                }
                i++;
            }
            return false;
        }
    }
}
