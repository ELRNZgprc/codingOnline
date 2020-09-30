package leetcode.problem;

public class ModifyString {
	/**
	 * 1576. 替换所有的问号
	 * https://leetcode-cn.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
	 */
	public String modifyString(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '?') {
				char a = 'a';
				while (((i > 0) && (sb.charAt(i - 1) == a)) || ((i < s.length() - 1) && (s.charAt(i + 1) == a))) {
					a++;
				}
				sb.append(a);
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}
}
