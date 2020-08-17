package leetcode.mst;

public class findMagicIndex {
    /**
     * 面试题 08.03
     * https://leetcode-cn.com/problems/magic-index-lcci/
     */
    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == i)
                return i;
            i = Math.max(i + 1, nums[i]);
        }
        return -1;
    }
}
