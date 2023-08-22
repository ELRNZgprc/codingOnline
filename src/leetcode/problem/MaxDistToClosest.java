package leetcode.problem;

/**
 * 849. 到最近的人的最大距离
 * https://leetcode.cn/problems/maximize-distance-to-closest-person/
 */
public class MaxDistToClosest {
    public int maxDistToClosest(int[] seats) {
        int left = -1;
        int max = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                if (left == -1 || i == seats.length - 1) {
                    max = Math.max(max, i - left);
                } else {
                    max = Math.max(max, (i - left) % 2 == 0 ? (i - left) / 2 : (i - left) / 2 + 1);
                }
            } else {
                left = i;
            }
        }
        return max;
    }
}
