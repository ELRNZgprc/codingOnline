package leetcode.mst;

import java.util.Stack;

/**
 * 面试题 17.21. 直方图的水量
 * https://leetcode-cn.com/problems/volume-of-histogram-lcci/
 */
public class Trap {
    public int trap(int[] height) {
        int ans = 0;
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stk.isEmpty() && height[i] > height[stk.peek()]) {
                int groud = stk.pop();
                if (!stk.isEmpty()) {
                    ans += (i - stk.peek() - 1) * (Math.min(height[stk.peek()], height[i]) - height[groud]);
                }
            }
            stk.push(i);
        }
        return ans;
    }
}
