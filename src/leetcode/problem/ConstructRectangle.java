package leetcode.problem;

/**
 * 492. 构造矩形
 * https://leetcode-cn.com/problems/construct-the-rectangle/
 */
public class ConstructRectangle {
    public int[] constructRectangle(int area) {
        int x = (int) Math.ceil(Math.sqrt(area));
        while (area % x != 0) {
            x++;
        }
        return new int[]{x, area / x};
    }
}
