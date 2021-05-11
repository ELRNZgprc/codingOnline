package leetcode.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1136. 平行课程
 * https://leetcode-cn.com/problems/parallel-courses/
 */
public class MinimumSemesters {
    public int minimumSemesters(int n, int[][] relations) {
        int[] pre = new int[n];
        List<Integer>[] next = new List[n];
        for (int i = 0; i < n; i++) {
            next[i] = new ArrayList<>();
        }

        for (int[] relation : relations) {
            next[relation[0] - 1].add(relation[1] - 1);
            pre[relation[1] - 1]++;
        }

        int ans = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (pre[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int now = queue.poll();
                for (int nn : next[now]) {
                    pre[nn]--;
                    if (pre[nn] == 0) {
                        queue.offer(nn);
                    }
                }
            }
            ans++;
        }

        for (int i = 0; i < n; i++) {
            if (pre[i] != 0) {
                return -1;
            }
        }
        return ans;
    }
}
