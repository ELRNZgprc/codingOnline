package leetcode.mst;

public class IsUnique {
	/** 
	 * 面试题 01.01. 判定字符是否唯一
	 * https://leetcode-cn.com/problems/is-unique-lcci/
	 */
	public boolean isUnique(String astr) {
		for (int i = 0; i < astr.length(); i++) {
			if (astr.lastIndexOf(astr.charAt(i)) != i) {
				return false;
			}
		}
		return true;
	}
}
