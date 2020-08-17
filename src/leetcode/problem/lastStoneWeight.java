package leetcode.problem;

import java.util.Arrays;

public class lastStoneWeight {
    /**
     * 1046
     * https://leetcode-cn.com/problems/last-stone-weight/
     */
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        int length = stones.length - 1;
        for (int i = length; i > 0; i--) {
            stones[length] -= stones[length - 1];
            stones[length - 1] = 0;
            Arrays.sort(stones);
        }
        return stones[length];
    }
}
