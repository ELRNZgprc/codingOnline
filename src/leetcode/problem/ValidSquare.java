package leetcode.problem;

public class ValidSquare {
    /**
     * 593. 有效的正方形
     * https://leetcode-cn.com/problems/valid-square/
     */
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return isStraight(p1, p2, p3) && isStraight(p1, p2, p4) && isStraight(p1, p3, p4) && isStraight(p3, p2, p4);
    }

    boolean isStraight(int[] p1, int[] p2, int[] p3) {
        int x = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
        int y = (p1[0] - p3[0]) * (p1[0] - p3[0]) + (p1[1] - p3[1]) * (p1[1] - p3[1]);
        int z = (p2[0] - p3[0]) * (p2[0] - p3[0]) + (p2[1] - p3[1]) * (p2[1] - p3[1]);

        return (((z > x) && (x == y) && (z == x + y)) || ((y > x) && (x == z) && (y == x + z)) || ((x > y) && (z == y) && (x == z + y)));
    }
}
