package leetcode.problem;

/**
 * 2337. 移动片段得到字符串
 * https://leetcode.cn/problems/move-pieces-to-obtain-a-string/
 */
public class CanChange {
    public boolean canChange(String start, String target) {
        int right = 0;
        for (int left = 0; left < start.length(); left++) {
            if (start.charAt(left) != '_') {
                while (right < target.length() && target.charAt(right) == '_') {
                    right++;
                }
                if (right == target.length() || start.charAt(left) != target.charAt(right)) {
                    return false;
                }
                if (start.charAt(left) == 'L' && left < right) {
                    return false;
                }
                if (start.charAt(left) == 'R' && left > right) {
                    return false;
                }
                right++;
            }
        }
        for (; right < target.length(); right++) {
            if (target.charAt(right) != '_') {
                return false;
            }
        }
        return true;
    }
}
