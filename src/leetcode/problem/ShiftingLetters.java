package leetcode.problem;

/**
 * 848. 字母移位
 * https://leetcode.cn/problems/shifting-letters/
 */
public class ShiftingLetters {
    public String shiftingLetters(String s, int[] shifts) {
        char[] cs = s.toCharArray();
        shifts[shifts.length - 1] = shifts[shifts.length - 1] % 26;
        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] = (shifts[i] + shifts[i + 1]) % 26;
        }
        for (int i = 0; i < cs.length; i++) {
            cs[i] += shifts[i];
            if (cs[i] > 'z') {
                cs[i] -= 26;
            }
        }
        return String.valueOf(cs);
    }
}
