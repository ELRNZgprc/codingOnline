package leetcode.problem;

public class OriginalDigits {
	/**
	 * 423. 从英文中重建数字
	 * https://leetcode-cn.com/problems/reconstruct-original-digits-from-english/
	 */
	public String originalDigits(String s) {
		int[] book = new int[10];
		int[] count = new int[26];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			count[c - 'a']++;
		}
		book[0] = count['z' - 'a'];
		book[2] = count['w' - 'a'];
		book[6] = count['x' - 'a'];
		book[8] = count['g' - 'a'];
		book[4] = count['u' - 'a'];
		book[3] = count['h' - 'a'] - book[8];
		book[7] = count['s' - 'a'] - book[6];
		book[5] = count['v' - 'a'] - book[7];
		book[9] = count['i' - 'a'] - book[6] - book[8] - book[5];
		book[1] = count['o' - 'a'] - book[0] - book[2] - book[4];

		StringBuilder res = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < book[i]; j++) {
				res.append(i);
			}
		}
		return res.toString();
	}
}
