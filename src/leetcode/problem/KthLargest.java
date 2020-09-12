package leetcode.problem;

import java.util.PriorityQueue;

public class KthLargest {
    /**
     * 703. 数据流中的第K大元素
     * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
     */
    PriorityQueue<Integer> queue;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < k) {
            queue.offer(val);
        } else if (queue.peek() < val) {
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }
}
