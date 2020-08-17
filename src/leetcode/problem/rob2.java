package leetcode.problem;

public class rob2 {
    /**
     * 213
     * https://leetcode-cn.com/problems/house-robber-ii/
     */
    public int rob2(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        } else if (length == 1) {
            return nums[0];
        }

        int[] memory = new int[length];

        memory[0] = 0;
        memory[1] = nums[1];

        for (int i = 2; i < length; i++) {
            memory[i] = Math.max(memory[i - 2] + nums[i], memory[i - 1]);
        }

        int ans = memory[length - 1];

        memory[length - 1] = 0;
        memory[length - 2] = nums[length - 2];

        for (int j = length - 3; j > -1; j--) {
            memory[j] = Math.max(memory[j + 2] + nums[j], memory[j + 1]);
        }

        return Math.max(ans, memory[0]);
    }
}
