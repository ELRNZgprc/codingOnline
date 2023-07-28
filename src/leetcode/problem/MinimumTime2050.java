package leetcode.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 2050. 并行课程 III
 * https://leetcode.cn/problems/parallel-courses-iii/
 */
public class MinimumTime2050 {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<Integer>[] path = new List[n + 5];
        for (int i = 0; i < n; i++) {
            path[i] = new ArrayList<>();
        }
        int[] degree = new int[n + 5];
        for (int[] r : relations) {
            path[r[0] - 1].add(r[1] - 1);
            degree[r[1] - 1]++;
        }
        int[] dis = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                q.add(i);
                dis[i] = time[i];
            }
        }
        while (!q.isEmpty()) {
            int a = q.poll();
            for (int b : path[a]) {
                dis[b] = Math.max(dis[b], dis[a] + time[b]);
                degree[b]--;
                if (degree[b] == 0) {
                    q.add(b);
                }
            }
        }
        int ans = 0;
        for (int a : dis) {
            ans = Math.max(ans, a);
        }
        return ans;
    }
}
