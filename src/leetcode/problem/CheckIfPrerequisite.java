package leetcode.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheckIfPrerequisite {
    /**
     * 1462. 课程安排 IV
     * https://leetcode-cn.com/problems/course-schedule-iv/
     */
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] map = new boolean[n][n];
        for (int[] pre : prerequisites) {
            map[pre[0]][pre[1]] = true;
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            ans.add(isPre(map, query[0], query[1]));
        }
        return ans;
    }

    boolean isPre(boolean[][] map, int p, int q) {
        if (map[p][q]) {
            return true;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < map.length; i++) {
            if (map[p][i]) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int np = queue.poll();

            for (int i = 0; i < map.length; i++) {
                if (map[np][i]) {
                    if (!map[p][i]) {
                        queue.offer(i);
                        map[p][i] = true;
                    }
                    if (q == i) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
