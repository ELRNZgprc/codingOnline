package leetcode.problem;

/**
 * 2432. 处理用时最长的那个任务的员工
 * https://leetcode.cn/problems/the-employee-that-worked-on-the-longest-task/
 */
public class HardestWorker {
    public int hardestWorker(int n, int[][] logs) {
        int cur = logs[0][1], id = logs[0][0];
        for (int i = 1; i < logs.length; i++) {
            if (logs[i][1] - logs[i - 1][1] > cur) {
                cur = logs[i][1] - logs[i - 1][1];
                id = logs[i][0];
            } else if (logs[i][1] - logs[i - 1][1] == cur && logs[i][0] < id) {
                id = logs[i][0];
            }
        }
        return id;
    }
}
