package leetcode.problem;

import java.util.*;

/**
 * 1172. 餐盘栈
 * https://leetcode.cn/problems/dinner-plate-stacks/
 */
public class DinnerPlates {
    int cap;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    List<Deque<Integer>> l = new ArrayList<>();

    public DinnerPlates(int capacity) {
        this.cap = capacity;
    }

    public void push(int val) {
        if (pq.size() != 0) {
            l.get(pq.poll()).push(val);
            return;
        }
        if (l.size() == 0) {
            l.add(new ArrayDeque<Integer>());
            l.get(l.size() - 1).push(val);
            return;
        }
        Deque<Integer> last = l.get(l.size() - 1);
        if (last.size() == cap) {
            l.add(new ArrayDeque<Integer>());
            l.get(l.size() - 1).push(val);
        } else {
            last.push(val);
        }
    }

    public int pop() {
        int i = l.size() - 1;
        // 最右边空栈需要去除，减小搜索 从右往左第一个非空栈 的消耗
        while (i >= 0 && l.get(i).size() == 0) {
            l.remove(i);
            // 去除栈的同时，去除优先队列中存的对应索引值，不去除会影响push操作
            while (!pq.isEmpty() && pq.peek() == i) {
                pq.poll();
            }
            i--;
        }
        if (l.size() == 0 || i < 0) {
            return -1;
        }
        return l.get(i).pop();
    }

    public int popAtStack(int index) {
        if (l.size() == 0 || index >= l.size() || l.get(index).size() == 0) {
            return -1;
        }
        pq.add(index);
        return l.get(index).pop();
    }
}
