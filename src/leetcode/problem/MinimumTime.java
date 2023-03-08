package leetcode.problem;

import java.util.Arrays;

/**
 * 2187. 完成旅途的最少时间
 * https://leetcode.cn/problems/minimum-time-to-complete-trips/
 */
public class MinimumTime {
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long left = 1;
        long right = (long) totalTrips * time[0];
        while (left < right) {
            long mid = (left + right) >>> 1;
            long trips = 0;
            for (int t : time) {
                trips += mid / t;
            }
            if (trips >= totalTrips) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
