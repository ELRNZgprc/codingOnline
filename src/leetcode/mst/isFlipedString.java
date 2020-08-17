package leetcode.mst;

public class isFlipedString {
    /**
     * 面试题 01.09
     * https://leetcode-cn.com/problems/string-rotation-lcci/
     */
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        String ss = s2 + s2;
        return ss.contains(s1);
    }
}
