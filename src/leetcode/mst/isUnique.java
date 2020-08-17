package leetcode.mst;

public class isUnique {
    /**
     * 面试题 01.01
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
