package leetcode.problem;

import java.util.Stack;

public class Calculate {
    /**
     * 227. 基本计算器 II
     * https://leetcode-cn.com/problems/basic-calculator-ii/
     */
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char opt = '+';
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            }
            if ((!Character.isDigit(ch) && (ch != ' ')) || (i == s.length() - 1)) {
                switch (opt) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                }
                opt = ch;
                num = 0;
            }
        }

        int ans = 0;
        while (!stack.empty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
