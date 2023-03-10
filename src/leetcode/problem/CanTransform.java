package leetcode.problem;

/**
 * 777. 在LR字符串中交换相邻字符
 * https://leetcode.cn/problems/swap-adjacent-in-lr-string/
 */
public class CanTransform {
    public boolean canTransform(String start, String end) {
        int i = 0;
        int j = 0;
        int n = start.length();
        while (true) {
            while (i < n && start.charAt(i) == 'X') i++;
            while (j < n && end.charAt(j) == 'X') j++;
            if (i == n || j == n) break;
            if (start.charAt(i) != end.charAt(j)) {
                return false;
            } else {
                if (start.charAt(i) == 'L' && i < j) return false;
                if (start.charAt(i) == 'R' && i > j) return false;
                i++;
                j++;
            }
        }
        return i == n && j == n;
    }
}
