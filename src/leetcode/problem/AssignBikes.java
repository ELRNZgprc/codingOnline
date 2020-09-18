package leetcode.problem;

public class AssignBikes {
    /**
     * 1066. 校园自行车分配 II
     * https://leetcode-cn.com/problems/campus-bikes-ii/
     */
    int min1066;

    public int assignBikes(int[][] workers, int[][] bikes) {
        min1066 = Integer.MAX_VALUE;
        int n = workers.length;
        int m = bikes.length;
        int[][] distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                distance[i][j] = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
            }
        }
        work1066(distance, new boolean[m], 0, 0);
        return min1066;
    }

    void work1066(int[][] distance, boolean[] flags, int n, int sum) {
        if (sum > min1066) {
            return;
        }
        if (n >= distance.length) {
            min1066 = sum;
        } else {
            for (int i = 0; i < flags.length; i++) {
                if (!flags[i]) {
                    flags[i] = true;
                    work1066(distance, flags, n + 1, sum + distance[n][i]);
                    flags[i] = false;
                }
            }
        }
    }
}
