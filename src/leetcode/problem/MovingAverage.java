package leetcode.problem;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    /**
     * 346. 数据流中的移动平均值
     * https://leetcode-cn.com/problems/moving-average-from-data-stream/
     */
    private int size = 0;
    private double sum = 0.0;
    private Queue<Integer> queue = new LinkedList<>();

    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        sum += val;
        queue.offer(val);
        if (queue.size() > this.size) {
            sum -= queue.remove();
        }
        return sum / queue.size();
    }
}
