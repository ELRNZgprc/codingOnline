package leetcode.problem;

public class search704 {
    /**
     * 704
     * https://leetcode-cn.com/problems/binary-search/
     */
    public int search704(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int half = (i + j) / 2;
            if (nums[half] == target) {
                return half;
            } else if (nums[half] > target) {
                j = half - 1;
            } else {
                i = half + 1;
            }
        }
        return -1;
    }
}
