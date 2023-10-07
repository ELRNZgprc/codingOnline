package leetcode.problem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 901. 股票价格跨度
 * https://leetcode.cn/problems/online-stock-span/
 */
public class StockSpanner {
    Deque<int[]> stack;
    int idx;

    public StockSpanner() {
        stack = new ArrayDeque<int[]>();
        stack.push(new int[]{-1, Integer.MAX_VALUE});
        idx = -1;
    }

    public int next(int price) {
        idx++;
        while (price >= stack.peek()[1]) {
            stack.pop();
        }
        int ret = idx - stack.peek()[0];
        stack.push(new int[]{idx, price});
        return ret;
    }
}
