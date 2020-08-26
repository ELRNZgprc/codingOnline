package leetcode.problem;

public class ReachingPoints {
    /**
     * 780. 到达终点
     * https://leetcode-cn.com/problems/reaching-points/
     */
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while ((tx > 0) && (ty > 0)) {
            if ((tx == sx) && (ty == sy)) {
                return true;
            }
            if (ty > tx) {
                ty -= Math.max((ty - sy) / tx, 1) * tx;
            } else {
                tx -= Math.max((tx - sx) / ty, 1) * ty;
            }
        }
        return false;
    }
}
