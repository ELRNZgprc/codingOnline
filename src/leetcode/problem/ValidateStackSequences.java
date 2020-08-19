package leetcode.problem;

import java.util.Stack;

public class ValidateStackSequences {
    /**
     * 946. 验证栈序列
     * https://leetcode-cn.com/problems/validate-stack-sequences/
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while ((!stack.isEmpty()) && (stack.peek() == popped[j])) {
                stack.pop();
                j++;
            }
        }
        while (!stack.isEmpty() && j < popped.length) {
            if (stack.peek() == popped[j]) {
                stack.pop();
                j++;
            } else {
                return false;
            }
        }
        return true;
    }
}
