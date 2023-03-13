package leetcode.problem;

import java.util.Arrays;

/**
 * 961. 在长度 2N 的数组中找出重复 N 次的元素
 * https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/
 */
public class RepeatedNTimes {
    public int repeatedNTimes(int[] nums) {
//        Arrays.sort(nums);
//        int len = nums.length / 2;
//        if (nums[len] != nums[len - 1]) {
//            if (nums[len] == nums[len + 1]) {
//                return nums[len];
//            }
//            return nums[len - 1];
//        }
//        return nums[len];
        for (int i = 0; i < nums.length - 2; i++) {
            if ((nums[i] == nums[i + 1]) || (nums[i] == nums[i + 2])) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}
