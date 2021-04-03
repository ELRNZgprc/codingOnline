package leetcode.problem;

/**
 * 55. 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        int target = nums.length - 1;

        for (int i = nums.length - 2; i > -1; i--) {
            if (nums[i] >= target - i) {
                target = i;
            }
        }

        return target == 0;
    }
}
