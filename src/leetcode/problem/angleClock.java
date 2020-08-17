package leetcode.problem;

public class angleClock {
    /**
     * 1344
     * https://leetcode-cn.com/problems/angle-between-hands-of-a-clock/
     */
    public double angleClock(int hour, int minutes) {
        double c = Math.abs(minutes * 6 - (hour % 12 * 30 + minutes / 2.0));
        return Math.min(c, 360 - c);
    }
}
