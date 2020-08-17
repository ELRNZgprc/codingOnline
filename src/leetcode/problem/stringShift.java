package leetcode.problem;

public class stringShift {
    /**
     * 1427
     * https://leetcode-cn.com/problems/perform-string-shifts/
     */
    public String stringShift(String s, int[][] shift) {
        int length = s.length();
        int move = 0;
        for (int i = 0; i < shift.length; i++) {
            if (shift[i][0] == 0) {
                move += shift[i][1];
            } else {
                move -= shift[i][1];
            }
        }

        move %= length;
        move = (move < 0) ? move + length : move;

        s = s + s;
        return s.substring(move, move + length);
    }
}
