package leetcode.problem;

/**
 * 962. 最大宽度坡
 * https://leetcode-cn.com/problems/maximum-width-ramp/
 */
public class MaxWidthRamp {
    public int maxWidthRamp(int[] nums) {
        int length = nums.length - 1;
        while (length > 0) {
            for (int i = 0; i < nums.length - length; i++) {
                if (nums[i + length] >= nums[i]) {
                    return length;
                }
            }
            length--;
        }
        return 0;
    }
}
