package leetcode.problem;

/**
 * 2594. 修车的最少时间
 * https://leetcode.cn/problems/minimum-time-to-repair-cars/description/
 */
public class RepairCars {
    public long repairCars(int[] ranks, int cars) {
        if (ranks.length == 1) {
            return (long) ranks[0] * cars * cars;
        }
        int[] rankHash = new int[101];
        int min = 101;
        for (int rank : ranks) {
            rankHash[rank]++;
            min = Math.min(min, rank);
        }
        long left = 0L;
        long right = (long) min * cars * cars;
        while (left < right) {
            long mid = left + right >> 1;
            long count = 0L;
            for (int i = 1; i <= 100; i++) {
                count += rankHash[i] * (long) Math.sqrt( mid / i);
            }
            if (count >= cars) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
