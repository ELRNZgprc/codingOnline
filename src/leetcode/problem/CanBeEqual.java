package leetcode.problem;

import java.util.Arrays;

public class CanBeEqual {
    /**
     * 1460. 通过翻转子数组使两个数组相等
     * https://leetcode-cn.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/
     */
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) {
            return false;
        }
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }
}
