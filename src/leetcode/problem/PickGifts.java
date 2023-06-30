package leetcode.problem;

import java.util.PriorityQueue;

/**
 * 2558. 从数量最多的堆取走礼物
 * https://leetcode.cn/problems/take-gifts-from-the-richest-pile/
 */
public class PickGifts {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int g : gifts) {
            queue.add(g);
        }
        for (int i = 0; i < k; i++) {
            int max = queue.poll();
            queue.add((int) Math.sqrt(max));
        }
        long ans = 0;
        for (int i : queue) {
            ans += i;
        }
        return ans;
    }
}
