package leetcode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1630. 等差子数组
 * https://leetcode.cn/problems/arithmetic-subarrays/
 */
public class CheckArithmeticSubarrays {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int[] arr = new int[r[i] - l[i] + 1];
            System.arraycopy(nums, l[i], arr, 0, r[i] - l[i] + 1);
            Arrays.sort(arr);
            boolean res = true;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] - arr[j - 1] != arr[1] - arr[0]) {
                    res = false;
                    break;
                }
            }
            result.add(res);
        }
        return result;
    }
}
