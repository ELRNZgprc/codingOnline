package leetcode.problem;

import java.util.HashSet;

/**
 * 2350. 不可能得到的最短骰子序列
 * https://leetcode.cn/problems/shortest-impossible-sequence-of-rolls/
 */
public class ShortestSequence {
    public int shortestSequence(int[] rolls, int k) {
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        for (int roll : rolls) {
            set.add(roll);
            if (set.size() == k) {
                res++;
                set.clear();
            }
        }
        return res + 1;
    }
}
