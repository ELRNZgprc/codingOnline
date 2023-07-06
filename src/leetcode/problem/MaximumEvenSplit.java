package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 2178. 拆分成最多数目的正偶数之和
 * https://leetcode.cn/problems/maximum-split-of-positive-even-integers/
 */
public class MaximumEvenSplit {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if (finalSum % 2 != 0) {
            return res;
        }
        long max = 0;
        while (finalSum > max) {
            max += 2;
            finalSum -= max;
            if (finalSum <= max) {
                max += finalSum;
                finalSum = 0;
            }
            res.add(max);
        }
        return res;
    }
}
