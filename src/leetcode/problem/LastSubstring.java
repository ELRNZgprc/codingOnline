package leetcode.problem;

/**
 * 1163. 按字典序排在最后的子串
 * https://leetcode.cn/problems/last-substring-in-lexicographical-order/
 */
public class LastSubstring {
    public String lastSubstring(String s) {
        int n = s.length(), l = 0, r = 1, i = l, j = r;
        while (j < n) {
            char c1 = s.charAt(i), c2 = s.charAt(j);
            if (c1 > c2) {
                r = j + 1;
                i = l;
                j++;
            } else if (c1 < c2) {
                l = Math.max(i + 1, r);
                r = l + 1;
                i = l;
                j = r;
            } else {
                i++;
                j++;
            }
        }
        return s.substring(l);
    }
}
