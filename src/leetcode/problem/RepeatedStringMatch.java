package leetcode.problem;

public class RepeatedStringMatch {
	/**
	 * 686. 重复叠加字符串匹配
	 * https://leetcode-cn.com/problems/repeated-string-match/
	 */
	public int repeatedStringMatch(String A, String B) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (sb.length() <= (2 * A.length() + B.length())) {
			sb.append(A);
			i++;
			if (sb.toString().contains(B)) {
				return i;
			}
		}
		return -1;
	}
}
