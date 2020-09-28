package leetcode.problem;

public class Rob {
    /**
     * 198. 打家劫舍
     * https://leetcode-cn.com/problems/house-robber/
     */
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        } else if (length == 1) {
            return nums[0];
        } else {
            int[] memory = new int[length];

            memory[0] = nums[0];
            memory[1] = Math.max(nums[0], nums[1]);

            for (int i = 2; i < length; i++) {
                memory[i] = Math.max(memory[i - 2] + nums[i], memory[i - 1]);
            }

            return memory[length - 1];
        }
    }
}
