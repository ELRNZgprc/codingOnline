package leetcode.offer;

public class FindRepeatNumber {
    /**
     * 剑指 Offer 03. 数组中重复的数字
     * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
     */
    public int findRepeatNumber(int[] nums) {
        int[] hash = new int[nums.length];
        for (int num : nums) {
            if (hash[num] != 0) {
                return num;
            }
            hash[num]++;
        }
        return -1;
    }
}
