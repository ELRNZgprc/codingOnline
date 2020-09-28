package leetcode.problem;

public class AddBinary {
	/**
	 * 67. 二进制求和
	 * https://leetcode-cn.com/problems/add-binary/
	 */
	public String addBinary(String a, String b) {
		char[] aa = new StringBuilder(a).reverse().toString().toCharArray();
		char[] bb = new StringBuilder(b).reverse().toString().toCharArray();
		int length = Math.max(a.length(), b.length());
		char[] cc = new char[length + 1];
		for (int i = 0; i < length; i++) {
			cc[i] = '0';
			if (i < a.length() && aa[i] == '1') {
				cc[i]++;
			}
			if (i < b.length() && bb[i] == '1') {
				cc[i]++;
			}
		}
		cc[length] = '0';
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			if (cc[i] > '1') {
				cc[i] -= 2;
				cc[i + 1]++;
			}
			sb.append(cc[i]);
		}
		if (cc[length] != '0') {
			sb.append(cc[length]);
		}
		return sb.reverse().toString();
	}
}
