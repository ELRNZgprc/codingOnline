package leetcode.problem;

import java.util.Arrays;

public class canBeEqual {
    /**
     * 1460
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
