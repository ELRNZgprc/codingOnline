package leetcode.problem;

/**
 * 1419. 数青蛙
 * https://leetcode.cn/problems/minimum-number-of-frogs-croaking/
 */
public class MinNumberOfFrogs {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int c = 0, k = 0, r = 0, a = 0, o = 0;
        int res = 0;
        for (char cc : croakOfFrogs.toCharArray()) {
            if (cc == 'c') {
                c++;
            } else if (cc == 'r') {
                r++;
            } else if (cc == 'o') {
                o++;
            } else if (cc == 'a') {
                a++;
            } else if (cc == 'k') {
                k++;
            }
            res = Math.max(c - k, res);
            if (!(c >= r && r >= o && o >= a && a >= k)) {
                return -1;
            }
        }
        if (c == a && a == o && o == k && r == c)
            return res;
        return -1;
    }
}
