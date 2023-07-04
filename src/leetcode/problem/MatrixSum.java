package leetcode.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 2679. 矩阵中的和
 * https://leetcode.cn/problems/sum-in-a-matrix/
 */
public class MatrixSum {
    public int matrixSum(int[][] nums) {
        List<PriorityQueue<Integer>> matrix = new ArrayList<>();
        int ans = 0;
        for (int[] num : nums) {
            PriorityQueue<Integer> heap = new PriorityQueue<>(nums[0].length, (o1, o2) -> o2 - o1);
            for (int j = 0; j < nums[0].length; j++) {
                heap.offer(num[j]);
            }
            matrix.add(heap);
        }
        for (int j = 0; j < nums[0].length; j++) {
            int max = Integer.MIN_VALUE;
            for (PriorityQueue<Integer> heap : matrix) {
                if (!heap.isEmpty()) {
                    Integer head = heap.poll();
                    max = Math.max(max, head);
                }
            }
            ans += max;
        }
        return ans;
    }
}
