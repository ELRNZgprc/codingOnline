package leetcode.problem;

import java.util.LinkedList;
import java.util.Queue;

public class CanFinish {
    /**
     * 207. 课程表
     * https://leetcode-cn.com/problems/course-schedule/
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] counts = new int[numCourses];
        Queue<Integer> safety = new LinkedList<>();
        for (int[] i : prerequisites) {
            counts[i[0]]++;
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0) {
                safety.offer(i);
            }
        }

        while (safety.size() != 0) {
            int poll = safety.poll();
            for (int[] i : prerequisites) {
                if (i[1] == poll) {
                    counts[i[0]]--;
                    if (counts[i[0]] == 0) {
                        safety.offer(i[0]);
                    }
                }
            }
        }

        for (int c : counts) {
            if (c != 0) return false;
        }
        return true;
    }
}
