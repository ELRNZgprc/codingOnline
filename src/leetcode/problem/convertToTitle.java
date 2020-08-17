package leetcode.problem;

public class convertToTitle {
    /**
     * 168
     * https://leetcode-cn.com/problems/excel-sheet-column-title/
     */
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) (n % 26 + 'A'));
            n /= 26;
        }
        return sb.reverse().toString();
    }
}
