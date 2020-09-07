package leetcode.problem;

public class FirstMissingPositive {
    /**
     * 41. 缺失的第一个正数
     * https://leetcode-cn.com/problems/first-missing-positive/
     */
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            while ((nums[i] > 0) && (nums[i] < length + 1) && (nums[i] != nums[nums[i] - 1])) {
                int a = nums[i];
                nums[i] = nums[a - 1];
                nums[a - 1] = a;
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return length + 1;
    }
}
