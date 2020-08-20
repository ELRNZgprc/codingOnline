package leetcode.problem;

public class IsMajorityElement {
    /**
     * 1150. 检查一个数是否在数组中占绝大多数
     * https://leetcode-cn.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/
     */
    public boolean isMajorityElement(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
            }
        }
        return (count > nums.length / 2);
    }
}
