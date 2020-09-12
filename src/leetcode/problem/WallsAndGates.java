package leetcode.problem;

public class WallsAndGates {
    /**
     * 286. 墙与门
     * https://leetcode-cn.com/problems/walls-and-gates/
     */
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }

    public void dfs(int[][] rooms, int i, int j, int dis) {
        if ((i > -1) && (i < rooms.length) && (j > -1) && (j < rooms[0].length)) {
            if (rooms[i][j] >= dis) {
                rooms[i][j] = dis;
                dfs(rooms, i + 1, j, dis + 1);
                dfs(rooms, i - 1, j, dis + 1);
                dfs(rooms, i, j + 1, dis + 1);
                dfs(rooms, i, j - 1, dis + 1);
            }
        }
    }
}
