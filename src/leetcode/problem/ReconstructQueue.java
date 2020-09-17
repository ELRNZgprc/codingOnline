package leetcode.problem;

import java.util.Arrays;

public class ReconstructQueue {
    /**
     * 406. 根据身高重建队列
     * https://leetcode-cn.com/problems/queue-reconstruction-by-height/
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, ((o1, o2) -> o1[0] == o2[0] ? (o1[1] - o2[1]) : o1[0] - o2[0]));
        int[][] ans = new int[people.length][2];
        Arrays.fill(ans, new int[]{Integer.MIN_VALUE, 0});
        for (int[] p : people) {
            int i = 0;
            int count = 0;
            while ((ans[i][0] != Integer.MIN_VALUE) || (count < p[1])) {
                if ((ans[i][0] == p[0]) || (ans[i][0] == Integer.MIN_VALUE)) {
                    count++;
                }
                i++;
            }
            ans[i] = p;
        }
        return ans;
    }
}
