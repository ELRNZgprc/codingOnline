package leetcode.mst;

import java.util.Arrays;

public class SubSort {
    /**
     * 面试题 16.16. 部分排序
     * https://leetcode-cn.com/problems/sub-sort-lcci/
     */
    public int[] subSort(int[] array) {
        if (array.length < 2) {
            return new int[]{-1, -1};
        }
        int[] na = array.clone();
        Arrays.sort(array);
        int left = -1;
        int right = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != na[i]) {
                if (left == -1) {
                    left = i;
                }
                right = i;
            }
        }
        return new int[]{left, right};
    }
}
