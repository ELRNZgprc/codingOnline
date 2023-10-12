package leetcode.problem;

import java.util.PriorityQueue;

/**
 * 2593. 标记所有元素后数组的分数
 * https://leetcode.cn/problems/find-score-of-an-array-after-marking-all-elements/
 */
public class FindScore {
    public static long findScore(int[] nums) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        boolean[] mark = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            queue.add(new int[]{nums[i], i});
        }
        long res = 0L;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (!mark[now[1]]) {
                res += now[0];
                mark[now[1]] = true;
                if (now[1] - 1 >= 0) {
                    mark[now[1] - 1] = true;
                }
                if (now[1] + 1 < nums.length) {
                    mark[now[1] + 1] = true;
                }
            }
        }
        return res;
    }
}