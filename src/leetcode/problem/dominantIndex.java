package leetcode.problem;

public class dominantIndex {
    /**
     * 747
     * https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/
     */
    public int dominantIndex(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int max;
        int maxp;
        if (nums[0] > nums[1]) {
            max = 0;
            maxp = 1;
        } else {
            maxp = 0;
            max = 1;
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > nums[max]) {
                maxp = max;
                max = i;
            } else if (nums[i] > nums[maxp]) {
                maxp = i;
            }
        }
        return (nums[max] >= (nums[maxp] * 2)) ? max : -1;
    }
}
