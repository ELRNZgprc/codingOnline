package leetcode.problem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1197. 进击的骑士
 * https://leetcode-cn.com/problems/minimum-knight-moves/
 */
public class MinKnightMoves {
    public int minKnightMoves(int x, int y) {
        int[][] dis = new int[][]{{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
        if ((x == 0) && (y == 0)) {
            return 0;
        }
        x = Math.abs(x) + 2;
        y = Math.abs(y) + 2;
        boolean[][] visited = new boolean[x + 2][y + 2];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{2, 2});
        visited[2][2] = true;
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;
            for (int i = 0; i < size; i++) {
                int[] location = queue.poll();
                for (int[] dd : dis) {
                    int xx = location[0] + dd[0];
                    int yy = location[1] + dd[1];
                    if ((xx >= 0) && (xx < visited.length) && (yy >= 0) && (yy < visited[0].length)) {
                        if ((xx == x) && (yy == y)) {
                            return ans;
                        }
                        if (!visited[xx][yy]) {
                            visited[xx][yy] = true;
                            queue.add(new int[]{xx, yy});
                        }
                    }
                }
            }
        }
        return -1;
    }
}
