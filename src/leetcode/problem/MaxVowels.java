package leetcode.problem;

import java.util.HashSet;

/**
 * 1456. 定长子串中元音的最大数目
 * https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 */
public class MaxVowels {
    public int maxVowels(String s, int k) {
        HashSet<Character> hs = new HashSet<>();
        hs.add('a');
        hs.add('e');
        hs.add('i');
        hs.add('o');
        hs.add('u');
        int ans = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < k; i++) {
            if (hs.contains(c[i])) {
                ans++;
            }
        }
        int count = ans;
        for (int i = k; i < s.length(); i++) {
            if (hs.contains(c[i])) {
                count++;
            }
            if (hs.contains(c[i - k])) {
                count--;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
