package leetcode.problem;

import java.util.Stack;

public class SumSubarrayMins {
    /**
     * 907. 子数组的最小值之和
     * https://leetcode-cn.com/problems/sum-of-subarray-minimums/
     */
    public int sumSubarrayMins(int[] A) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            while ((!stack.isEmpty()) && (A[stack.peek()] > A[i])) {
                int k = stack.pop();
                ans += A[k] * (i - k) * (stack.isEmpty() ? k + 1 : k - stack.peek());
                ans %= 1000000007;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int k = stack.pop();
            ans += A[k] * (A.length - k) * (stack.isEmpty() ? k + 1 : k - stack.peek());
            ans %= 1000000007;
        }
        return ans;
    }
}
