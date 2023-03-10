package leetcode.problem;

import java.util.PriorityQueue;

/**
 * 2208. 将数组和减半的最少操作次数
 * https://leetcode.cn/problems/minimum-operations-to-halve-array-sum/
 */
public class HalveArray {
    public int halveArray(int[] nums) {
        double target = 0.0;
        PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> b - a > 0 ? 1 : -1);
        for (int num : nums) {
            target += (double) num;
            pq.add((double) num);
        }
        double count = 0.0;
        int ans = 0;
        while (count < target / 2.0) {
            double poll = pq.poll();
            count += poll / 2.0;
            pq.add(poll / 2.0);
            ans++;
        }
        return ans;
    }
}
