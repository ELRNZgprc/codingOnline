package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 2032. 至少在两个数组中出现的值
 * https://leetcode.cn/problems/two-out-of-three/
 */
public class TwoOutOfThree {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        boolean[][] hash = new boolean[101][4];
        for (int n : nums1) {
            hash[n][1] = true;
        }
        for (int n : nums2) {
            hash[n][2] = true;
        }
        for (int n : nums3) {
            hash[n][3] = true;
        }
        List<Integer> ans = new ArrayList<>();
        for (int n = 1; n <= 100; n++) {
            if ((hash[n][1] && (hash[n][2] || hash[n][3])) || (hash[n][2] && hash[n][3])) {
                ans.add(n);
            }
        }
        return ans;
    }
}
