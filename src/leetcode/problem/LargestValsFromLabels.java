package leetcode.problem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 1090. 受标签影响的最大值
 * https://leetcode.cn/problems/largest-values-from-labels/
 */
public class LargestValsFromLabels {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int[][] result = new int[values.length][2];
        for (int i = 0; i < values.length; i++) {
            result[i] = new int[]{values[i], labels[i]};
        }
        Arrays.sort(result, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        Map<Integer, Integer> map = new HashMap<>();
        for (int label : labels) {
            map.put(label, useLimit);
        }
        int r = 0;
        int count = 0;
        for (int[] ints : result) {
            if (map.get(ints[1]) != 0) {
                r += ints[0];
                map.put(ints[1], map.getOrDefault(ints[1], 0) - 1);
                count++;
            }
            if (count >= numWanted) break;
        }
        return r;
    }
}
