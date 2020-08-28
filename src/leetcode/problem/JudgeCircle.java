package leetcode.problem;

public class JudgeCircle {
    /**
     * 657. 机器人能否返回原点
     * https://leetcode-cn.com/problems/robot-return-to-origin/
     */
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'R':
                    x++;
                    break;
                case 'L':
                    x--;
                    break;
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
            }
        }
        return ((x == 0) && (y == 0));
    }
}
