package leetcode.problem;

/**
 * 2460. 对数组执行操作
 * https://leetcode.cn/problems/apply-operations-to-an-array/
 */
public class ApplyOperations {
    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        int[] ans = new int[nums.length];
        int flag = 0;
        for (int num : nums) {
            if (num != 0) {
                ans[flag] = num;
                flag++;
            }
        }
        return ans;
    }
}
