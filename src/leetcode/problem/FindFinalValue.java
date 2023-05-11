package leetcode.problem;

import java.util.Arrays;

/**
 * 2154. 将找到的值乘以 2
 * https://leetcode.cn/problems/keep-multiplying-found-values-by-two/
 */
public class FindFinalValue {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        for (int i : nums) {
            if (i == original)
                original *= 2;
        }
        return original;
    }
}
