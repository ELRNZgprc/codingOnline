package leetcode.problem;

public class RotateString {
    /**
     * 796. 旋转字符串
     * https://leetcode-cn.com/problems/rotate-string/
     */
    public boolean rotateString(String A, String B) {
        if (A.length() == B.length()) {
            return (B + B).contains(A);
        }
        return false;
    }
}
