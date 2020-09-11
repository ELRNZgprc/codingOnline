package leetcode.problem;

public class MaxPower {
    /**
     * 1446. 连续字符
     * https://leetcode-cn.com/problems/consecutive-characters/
     */
    public int maxPower(String s) {
        int max = 0;
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while ((j + 1 < s.length()) && (s.charAt(j + 1) == s.charAt(j))) {
                j++;
            }
            max = Math.max(max, j - i + 1);
            i = j + 1;
        }
        return max;
    }
}
