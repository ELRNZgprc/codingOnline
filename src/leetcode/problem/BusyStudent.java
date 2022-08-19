package leetcode.problem;

/**
 * 1450. 在既定时间做作业的学生人数
 * https://leetcode.cn/problems/number-of-students-doing-homework-at-a-given-time/
 */
public class BusyStudent {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int ans = 0;
        for (int i = 0; i < startTime.length; i++) {
            if ((queryTime >= startTime[i]) && (queryTime <= endTime[i])) {
                ans++;
            }
        }
        return ans;
    }
}
