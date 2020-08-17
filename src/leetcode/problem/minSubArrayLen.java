package leetcode.problem;

public class minSubArrayLen {
    /**
     * 209
     * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
     */
    public int minSubArrayLen(int s, int[] nums) {
        int i = -1;
        int j = -1;
        int sum = 0;
        int length = 0;
        while (i < nums.length - 1) {
            while ((i < nums.length - 1) && (sum < s)) {
                i++;
                sum += nums[i];
            }
            while (sum >= s) {
                if ((length == 0) || (i - j < length)) {
                    length = i - j;
                }
                j++;
                sum -= nums[j];
            }
        }
        return length;
    }
}
