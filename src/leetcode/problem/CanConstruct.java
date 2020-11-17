package leetcode.problem;

public class CanConstruct {
	/**
	 * 383. 赎金信
	 * https://leetcode-cn.com/problems/ransom-note/
	 */
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] chars = new int[26];
		for (char c : magazine.toCharArray()) {
			chars[c - 'a']++;
		}
		for (char c : ransomNote.toCharArray()) {
			if (chars[c - 'a'] > 0) {
				chars[c - 'a']--;
			} else {
				return false;
			}
		}
		return true;
	}
}
