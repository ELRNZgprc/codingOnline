package leetcode.problem;

import java.util.Arrays;

/**
 * 1935. 可以输入的最大单词数
 * https://leetcode.cn/problems/maximum-number-of-words-you-can-type/
 */
public class CanBeTypedWords {
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] flag = new boolean[26];
        Arrays.fill(flag, false);
        for (char c : brokenLetters.toCharArray()) {
            flag[c - 'a'] = true;
        }
        int ans = 0;
        String[] words = text.split(" ");
        for (String word : words) {
            boolean typeable = true;
            int i = 0;
            while (typeable && i < word.length()) {
                if (flag[word.charAt(i) - 'a']) {
                    typeable = false;
                }
                i++;
            }
            if (typeable) {
                ans++;
            }
        }
        return ans;
    }
}
