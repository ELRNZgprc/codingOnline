package leetcode.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AsteroidCollision {
    /**
     * 735. 行星碰撞
     * https://leetcode-cn.com/problems/asteroid-collision/
     */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                asteroid = 0 - asteroid;
                while ((!stack.isEmpty()) && (stack.peek() < asteroid)) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    list.add(0 - asteroid);
                } else {
                    if (stack.peek() == asteroid) {
                        stack.pop();
                    }
                }
            }
        }
        Stack<Integer> stack1 = new Stack<>();
        while (!stack.isEmpty()) {
            stack1.push(stack.pop());
        }
        while (!stack1.isEmpty()) {
            list.add(stack1.pop());
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
