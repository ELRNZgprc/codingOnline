package leetcode.problem;

public class jump {
    /**
     * 45
     * https://leetcode-cn.com/problems/jump-game-ii/
     */
    public int jump(int[] nums) {
        int[] record = new int[nums.length];

        record[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            record[i] = -1;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < nums.length) {
                    if ((record[i + j] == -1) || (record[i + j] > record[i] + 1)) {
                        record[i + j] = record[i] + 1;
                    }
                }
            }
        }

        return record[nums.length - 1];
    }
}
