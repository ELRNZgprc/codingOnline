package leetcode.problem;

import java.util.Arrays;

/**
 * 2389. 和有限的最长子序列
 * https://leetcode.cn/problems/longest-subsequence-with-limited-sum/
 */
public class AnswerQueries {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = 0;
            int right = sum.length - 1;
            int mid = left + (right - left) / 2;
            while (left < right) {
                if (sum[mid] == queries[i]) {
                    break;
                }
                if (sum[mid] < queries[i]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
                mid = left + (right - left + 1) / 2;
            }
            ans[i] = mid;
        }
        return ans;
    }
}
