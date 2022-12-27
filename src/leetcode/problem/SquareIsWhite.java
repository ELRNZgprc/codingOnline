package leetcode.problem;

/**
 * 1812. 判断国际象棋棋盘中一个格子的颜色
 * https://leetcode.cn/problems/determine-color-of-a-chessboard-square/
 */
public class SquareIsWhite {
    public boolean squareIsWhite(String coordinates) {
        return coordinates.charAt(0) % 2 + coordinates.charAt(1) % 2 == 1;
    }
}
