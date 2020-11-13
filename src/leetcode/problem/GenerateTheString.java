package leetcode.problem;

public class GenerateTheString {
	/**
	 * 1374. 生成每种字符都是奇数个的字符串
	 * https://leetcode-cn.com/problems/generate-a-string-with-characters-that-have-odd-counts/
	 */
	public String generateTheString(int n) {
		StringBuilder sb = new StringBuilder();

		if (n % 2 == 1) {
			for (int i = 0; i < n; i++) {
				sb.append('a');
			}
		} else {
			sb.append('b');
			for (int i = 1; i < n; i++) {
				sb.append('a');
			}
		}
		return sb.toString();
	}
}
