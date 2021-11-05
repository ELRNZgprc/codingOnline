package leetcode.problem;

import java.util.HashMap;

/**
 * 1218. 最长定差子序列
 * https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference/
 */
public class LongestSubsequence {
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            if (map.get(a - difference) != null) {
                int l = map.get(a - difference) + 1;
                map.put(a, l);
                ans = Math.max(ans, l);
            } else {
                map.put(a, 1);
            }
        }
        return ans;
    }
}
