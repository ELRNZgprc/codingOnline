package leetcode.problem;

import java.util.Arrays;

/**
 * 1288. 删除被覆盖区间
 * https://leetcode-cn.com/problems/remove-covered-intervals/
 */
public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int ans = 0;
        int right = 0;
        for (int[] i : intervals) {
            if (right < i[1]) {
                ans++;
                right = i[1];
            }
        }
        return ans;
    }
}
