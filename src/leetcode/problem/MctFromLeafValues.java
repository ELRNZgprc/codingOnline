package leetcode.problem;

import java.util.Stack;

/**
 * 1130. 叶值的最小代价生成树
 * https://leetcode.cn/problems/minimum-cost-tree-from-leaf-values/
 */
public class MctFromLeafValues {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);//哨兵
        int ans = 0;
        for (int j : arr) {
            while (stack.peek() < j)
                ans += stack.pop() * Math.min(j, stack.peek());
            stack.push(j);
        }

        while (stack.size() > 2)
            ans += stack.pop() * stack.peek();

        return ans;
    }
}
