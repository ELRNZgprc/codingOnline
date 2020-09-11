package leetcode.problem;

import java.util.PriorityQueue;
import java.util.Queue;

public class ConnectSticks {
    /**
     * 1167. 连接棒材的最低费用
     * https://leetcode-cn.com/problems/minimum-cost-to-connect-sticks/
     */
    public int connectSticks(int[] sticks) {
        if (sticks.length == 1) {
            return 0;
        }
        Queue<Integer> queue = new PriorityQueue<>();
        int ans = 0;
        for (int stick : sticks) {
            queue.add(stick);
        }
        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            ans += a + b;
            queue.add(a + b);
        }
        return ans;
    }
}
