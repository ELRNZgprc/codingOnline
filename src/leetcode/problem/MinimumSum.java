package leetcode.problem;

import java.util.Arrays;

/**
 * 2160. 拆分数位后四位数字的最小和
 * https://leetcode.cn/problems/minimum-sum-of-four-digit-number-after-splitting-digits/
 */
public class MinimumSum {
    public int minimumSum(int num) {
        int[] hash = new int[4];
        int i = 0;
        while (num > 0) {
            hash[i] = num % 10;
            num /= 10;
            i++;
        }
        Arrays.sort(hash);
        return hash[0] * 10 + hash[1] * 10 + hash[2] + hash[3];
    }
}
