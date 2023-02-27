package leetcode.problem;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 2570. 合并两个二维数组 - 求和法
 * https://leetcode.cn/problems/merge-two-2d-arrays-by-summing-values/
 */
public class MergeArrays {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] num : nums1) {
            map.put(num[0], num[1]);
        }
        for (int[] num : nums2) {
            map.put(num[0], map.getOrDefault(num[0], 0) + num[1]);
        }

        int[][] result = new int[map.size()][2];
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : entries) {
            result[count][0] = entry.getKey();
            result[count][1] = entry.getValue();
            count++;
        }
        return result;
    }
}
