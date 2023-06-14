package leetcode.problem;

/**
 * 2206. 将数组划分成相等数对
 * https://leetcode.cn/problems/divide-array-into-equal-pairs/
 */
public class DivideArray {
    public boolean divideArray(int[] nums) {
        boolean[] flag = new boolean[501];
        for (int num : nums) {
            flag[num] = !flag[num];
        }
        for (boolean f : flag) {
            if (f) {
                return false;
            }
        }
        return true;
    }
}
