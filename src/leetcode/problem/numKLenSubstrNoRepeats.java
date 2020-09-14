package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class numKLenSubstrNoRepeats {
    /**
     * 1100. 长度为 K 的无重复字符子串
     * https://leetcode-cn.com/problems/find-k-length-substrings-with-no-repeated-characters/
     */
    public int numKLenSubstrNoRepeats(String S, int K) {
        if (S.length() < K) {
            return 0;
        }
        if (K > 26) {
            return 0;
        }
        int[] count = new int[26];
        char[] chars = S.toCharArray();
        int ans = 0;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            count[chars[i] - 'a']++;
            if (count[chars[i] - 'a'] == 2) {
                list.add((Character) chars[i]);
            }
        }
        if (list.size() == 0) {
            ans++;
        }
        for (int i = 1; i < S.length() - K + 1; i++) {
            count[chars[i - 1] - 'a']--;
            if (count[chars[i - 1] - 'a'] == 1) {
                list.remove((Character) chars[i - 1]);
            }
            count[chars[i + K - 1] - 'a']++;
            if (count[chars[i + K - 1] - 'a'] == 2) {
                list.add((Character) chars[i + K - 1]);
            }
            if (list.size() == 0) {
                ans++;
            }
        }
        return ans;
    }
}
