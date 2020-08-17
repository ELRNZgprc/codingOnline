package leetcode.problem;

public class minMoves {
    /**
     * 453
     * https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/
     */
    public int minMoves(int[] nums) {
        int sum = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(nums[i], min);
        }
        return sum - min * nums.length;
    }
}
