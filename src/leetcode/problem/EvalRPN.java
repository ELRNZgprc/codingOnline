package leetcode.problem;

import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 * https://leetcode.cn/problems/evaluate-reverse-polish-notation/
 */
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        String operations = "+-*/";
        for (String token : tokens) {
            if (!operations.contains(token)) {
                stack.push(Integer.valueOf(token));
                continue;
            }
            int b = stack.pop();
            int a = stack.pop();
            switch (token) {
                case "+":
                    stack.push(a + b);
                    break;
                case "-":
                    stack.push(a - b);
                    break;
                case "*":
                    stack.push(a * b);
                    break;
                default:
                    stack.push(a / b);
                    break;
            }
        }
        return stack.pop();
    }
}
