package leetcode.problem;

import java.util.Stack;

public class dailyTemperatures {
    /**
     * 739
     * https://leetcode-cn.com/problems/daily-temperatures/
     */
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> z = new Stack<>();
        int[] ans = new int[T.length];
        z.push(T.length - 1);
        ans[T.length - 1] = 0;
        for (int i = T.length - 2; i >= 0; i--) {
            while ((!z.isEmpty()) && (T[z.peek()] <= T[i])) {
                z.pop();
            }

            if (!z.isEmpty()) {
                ans[i] = z.peek() - i;
            } else
                ans[i] = 0;

            z.push(i);
        }
        return ans;
    }
}
