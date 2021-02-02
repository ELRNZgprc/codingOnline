package leetcode.problem;

public class CharacterReplacement {
	/**
	 * 424. 替换后的最长重复字符
	 * https://leetcode-cn.com/problems/longest-repeating-character-replacement/
	 */
	public int characterReplacement(String s, int k) {
        int res = 0, len = s.length();
        if(len < 2)
            return len;
        int[] chars = new int[26];
        int left = 0, right = 0, maxCount = 0;
        while(right < len) {
            char ch = s.charAt(right);
            chars[ch - 'A']++;
            maxCount = Math.max(maxCount, chars[ch - 'A']);
            while(left <= right && ((right - left + 1) > maxCount + k)) {
                chars[s.charAt(left) - 'A']--;
                left++;     
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
