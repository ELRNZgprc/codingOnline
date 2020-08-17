package leetcode.problem;

public class lengthOfLongestSubstring {
    /**
     * 3
     * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
     */
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int[] hash = new int[128];
        for (int i = 0; i < 128; i++) {
            hash[i] = -1;
        }
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i);
            start = Math.max(start, hash[num] + 1);
            ans = Math.max(ans, i - start + 1);
            hash[num] = i;
        }
        return ans;
    }
}
