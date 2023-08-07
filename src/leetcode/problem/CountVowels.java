package leetcode.problem;

/**
 * 2063. 所有子字符串中的元音
 * https://leetcode.cn/problems/vowels-of-all-substrings/
 */
public class CountVowels {
    public long countVowels(String word) {
        long[] dp = new long[word.length() + 1];
        for (int i = 1; i <= word.length(); i++) {
            char c = word.charAt(i - 1);
            if ((c == 'a') || (c == 'e') || (c == 'i') || (c == 'o') || (c == 'u')) {
                dp[i] = dp[i - 1] + i;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        long ans = 0L;
        for (long l : dp) {
            ans += l;
        }
        return ans;
    }
}
