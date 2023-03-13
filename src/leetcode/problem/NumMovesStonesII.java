package leetcode.problem;

import java.util.Arrays;

/**
 * 1040. 移动石子直到连续 II
 * https://leetcode.cn/problems/moving-stones-until-consecutive-ii/
 */
public class NumMovesStonesII {
    public int[] numMovesStonesII(int[] stones) {
        int n = stones.length;
        Arrays.sort(stones);
        int max = (stones[n - 1] - stones[0] + 1 - n) - Math.min(stones[n - 1] - stones[n - 2] - 1, stones[1] - stones[0] - 1);
        int min = max;
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j + 1 < n && stones[j + 1] - stones[i] + 1 <= n)
                ++j;
            int step = n - (j - i + 1);
            if (j - i + 1 == n - 1 && stones[j] - stones[i] + 1 == n - 1)
                step = 2;
            min = Math.min(min, step);
        }
        return new int[]{min, max};
    }
}
