package leetcode.problem;

import java.util.Arrays;

/**
 * 1803. 统计异或值在范围内的数对有多少
 * https://leetcode.cn/problems/count-pairs-with-xor-in-a-range/
 */
public class CountPairs {
    public int countPairs(int[] nums, int low, int high) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int t = nums[i] ^ nums[j];
                if (t >= low && t <= high) res++;
            }
        }
        return res;
    }
}
