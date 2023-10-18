package leetcode.problem;

import java.util.PriorityQueue;

/**
 * 2530. 执行 K 次操作后的最大分数
 * https://leetcode.cn/problems/maximal-score-after-applying-k-operations/
 */
public class MaxKelements {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        long result = 0;
        int n = nums.length - 1;
        for (int j = 0; j <= n; j++) {
            queue.add(nums[j]);
        }
        while (k > 0) {
            k--;
            Integer number = queue.poll();
            result += number;
            number = number / 3 + (number % 3 == 0 ? 0 : 1);
            queue.add(number);
        }

        return result;
    }
}
