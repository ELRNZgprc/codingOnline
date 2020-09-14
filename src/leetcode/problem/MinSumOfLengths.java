package leetcode.problem;

import java.util.*;

public class MinSumOfLengths {
    /**
     * 1477. 找两个和为目标值且不重叠的子数组
     * https://leetcode-cn.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
     */
    public int minSumOfLengths(int[] arr, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int num = arr[0];
        while (i < arr.length) {
            while ((j + 1 < arr.length) && (num < target)) {
                j++;
                num += arr[j];
            }

            if ((num == target) && (j - i + 1 < min)) {
                for (Integer key : map.keySet()) {
                    if ((j - i + 1 + key) < min) {
                        for (int c : map.get(key)) {
                            if (i >= c + key) {
                                min = j - i + 1 + key;
                            }
                        }
                    }
                }
                if (map.containsKey(j - i + 1)) {
                    if (map.get(j - i + 1).size() < j - i + 2) {
                        map.get(j - i + 1).add(i);
                    }
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(j - i + 1, list);
                }
            }
            if (num > target) {
                while (num > target) {
                    num -= arr[i];
                    i++;
                }
            } else if (num == target) {
                num -= arr[i];
                i++;
            } else {
                i = arr.length;
            }
        }

        return (min == Integer.MAX_VALUE) ? -1 : min;
    }
}
