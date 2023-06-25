package leetcode.problem;

/**
 * 1401. 圆和矩形是否有重叠
 * https://leetcode.cn/problems/circle-and-rectangle-overlapping/
 */
public class CheckOverlap {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (radius * radius >= (i - xCenter) * (i - xCenter) + (j - yCenter) * (j - yCenter)) {
                    return true;
                }
            }
        }
        return false;
    }
}
