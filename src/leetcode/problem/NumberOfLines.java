package leetcode.problem;

public class NumberOfLines {
	/**
	 * 806. 写字符串需要的行数
	 * https://leetcode-cn.com/problems/number-of-lines-to-write-string/
	 */
	public int[] numberOfLines(int[] widths, String S) {
		int lines = 1;
		int posi = 0;
		for (char c : S.toCharArray()) {
			if (posi + widths[c - 'a'] <= 100) {
				posi += widths[c - 'a'];
			} else {
				lines++;
				posi = widths[c - 'a'];
			}
		}
		return new int[] { lines, posi };
	}
}
