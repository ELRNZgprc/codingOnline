package leetcode.problem;

public class pivotIndex {
    /**
     * 724
     * https://leetcode-cn.com/problems/find-pivot-index/
     */
    public int pivotIndex(int[] nums) {
        if (nums.length < 1) {
            return -1;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int i = -1;
        int sumleft = 0;
        while ((i + 1 < nums.length) && (sumleft * 2 + nums[i + 1] != sum)) {
            i++;
            sumleft += nums[i];
        }
        if (i + 1 < nums.length) {
            return i + 1;
        }
        return -1;
    }
}
