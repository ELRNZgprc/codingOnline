package leetcode.problem;

/**
 * 1326. 灌溉花园的最少水龙头数目
 * https://leetcode.cn/problems/minimum-number-of-taps-to-open-to-water-a-garden/
 */
public class MinTaps {
    public int minTaps(int n, int[] ranges) {
        int[] nums = new int[n + 1];
        for (int i = 0; i < ranges.length; i++) {
            int x = ranges[i];
            int a = Math.max(0, i - x);
            int b = Math.min(n, i + x);
            for (int j = a; j <= b; j++) {
                nums[j] = Math.max(nums[j], b);
            }
        }
        int max = 0;
        int res = 0;
        while (true) {
            int t = nums[max];
            if (t == max) {
                break;
            }
            res++;
            max = t;
        }
        if (max != n) {
            return -1;
        }
        return res;
    }
}