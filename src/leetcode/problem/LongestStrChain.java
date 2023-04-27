package leetcode.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1048. 最长字符串链
 * https://leetcode.cn/problems/longest-string-chain/
 */
public class LongestStrChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() == b.length() ? a.compareTo(b) : a.length() - b.length());
        int res = 1;
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            int len = 0;
            int n = w.length();
            for (int i = 0; i < n; i++) {
                String key = w.substring(0, i) + w.substring(i + 1);
                if (map.containsKey(key)) {
                    len = Math.max(len, map.get(key));
                }
            }
            map.put(w, len + 1);
            res = Math.max(res, len + 1);
        }
        return res;
    }
}
