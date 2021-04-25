package leetcode.problem;

import java.util.List;
import java.util.Stack;

/**
 * 1424. 对角线遍历 II
 * https://leetcode-cn.com/problems/diagonal-traverse-ii/
 */
public class FindDiagonalOrder {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int n = nums.size();

        int max = 0;
        for (int r = 0; r < n; r++) {
            max = Math.max(max, r + nums.get(r).size());
        }

        Stack<Integer>[] stacks = new Stack[max];
        for (int i = 0; i < max; i++) {
            stacks[i] = new Stack<>();
        }

        int size = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < nums.get(i).size(); j++) {
                stacks[i + j].push(nums.get(i).get(j));
                size++;
            }

        int[] ans = new int[size];
        int index = 0;
        for (int i = 0; i < max; i++) {
            while (!stacks[i].isEmpty()) {
                ans[index++] = stacks[i].pop();
            }
        }

        return ans;
    }
}
