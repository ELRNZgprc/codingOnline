package leetcode.problem;

public class removeElement {
    /**
     * 27
     * https://leetcode-cn.com/problems/remove-element/
     */
    public int removeElement(int[] nums, int val) {
        if (nums.length < 1) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[ans++] = nums[i];
            }
        }
        return ans;
    }
}
