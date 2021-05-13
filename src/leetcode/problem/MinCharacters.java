package leetcode.problem;

/**
 * 1737. 满足三条件之一需改变的最少字符数
 * https://leetcode-cn.com/problems/change-minimum-characters-to-satisfy-one-of-three-conditions/
 */
public class MinCharacters {
    public int minCharacters(String a, String b) {
        int[] aHash = new int[26];
        int[] bHash = new int[26];
        for (char c : a.toCharArray()) {
            aHash[c - 'a']++;
        }
        for (char c : b.toCharArray()) {
            bHash[c - 'a']++;
        }
        int n = a.length();
        int m = b.length();
        int ans = n + m;
        for (int i = 0; i < 26; i++) {
            ans = Math.min(ans, n + m - aHash[i] - bHash[i]);
        }

        for (int i = 1; i < 26; i++) {
            aHash[i] += aHash[i - 1];
            bHash[i] += bHash[i - 1];
        }
        for (int i = 0; i < 25; i++) {
            ans = Math.min(ans, aHash[i] + m - bHash[i]);
            ans = Math.min(ans, n - aHash[i] + bHash[i]);
        }
        return ans;
    }
}
