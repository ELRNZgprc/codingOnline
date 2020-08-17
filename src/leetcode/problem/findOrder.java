package leetcode.problem;

import java.util.LinkedList;
import java.util.Queue;

public class findOrder {
    /**
     * 210
     * https://leetcode-cn.com/problems/course-schedule-ii/
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] counts = new int[numCourses];
        Queue<Integer> safety = new LinkedList<>();
        Queue<Integer> record = new LinkedList<>();
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
            record.offer(poll);
            for (int[] i : prerequisites) {
                if (i[1] == poll) {
                    counts[i[0]]--;
                    if (counts[i[0]] == 0) {
                        safety.offer(i[0]);
                    }
                }
            }
        }

        if (record.size() == numCourses) {
            int[] ans = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                ans[i] = record.poll();
            }
            return ans;
        } else {
            return new int[0];
        }
    }
}
