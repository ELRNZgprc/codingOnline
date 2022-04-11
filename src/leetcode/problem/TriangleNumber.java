package leetcode.problem;

import java.util.Arrays;

/**
 * 611. 有效三角形的个数
 * https://leetcode-cn.com/problems/valid-triangle-number/
 */
public class TriangleNumber {
    public int triangleNumber(int[] nums) {
        int total = 0;
        if (nums == null || nums.length == 0) {
            return total;
        }
        // ASC 排序
        Arrays.sort(nums);

        // a + b > c // 任意两边之和大于第三边
        for (int i = nums.length -1; i > 1 ; i--) {
            int start = 0;
            int end = i -1;
            while (start < end) {
                if (nums[start] + nums[end] > nums[i]) {
                    total += (end - start);
                    end --;
                } else {
                    start ++;
                }
            }
        }
        return total;
    }
}
