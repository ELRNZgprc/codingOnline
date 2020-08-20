package leetcode.problem;

public class IsRobotBounded {
    /**
     * 1041. 困于环中的机器人
     * https://leetcode-cn.com/problems/robot-bounded-in-circle/
     */
    public boolean isRobotBounded(String instructions) {
        int[] location = {0, 0};
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int flag = 0;
        for (int i = 0; i < 4; i++) {
            for (char c : instructions.toCharArray()) {
                switch (c) {
                    case 'G':
                        location[0] += directions[flag][0];
                        location[1] += directions[flag][1];
                        break;
                    case 'L':
                        flag = (flag + 3) % 4;
                        break;
                    case 'R':
                        flag = (flag + 1) % 4;
                        break;
                }
            }
        }
        return ((flag == 0) && (location[0] == 0) && (location[1] == 0));
    }
}
