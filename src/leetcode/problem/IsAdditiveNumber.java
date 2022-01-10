package leetcode.problem;

/**
 * 306. 累加数
 * https://leetcode-cn.com/problems/additive-number/
 */
public class IsAdditiveNumber {
    public boolean isAdditiveNumber(String s) {
        if (s.length() < 3) {
            return false;
        }

        return dfs(s, s.length(), 0, 0, 0, 0);
    }

    private boolean dfs(String s, int len, long pre, long sum, int start, int k) {
        if (start == len) {
            return k > 2;
        }
        for (int i = start; i < len; i++) {
            long cur = isValid(s, start, i);
            if (cur < 0) {
                return false;
            }
            if (k > 1 && cur != sum) {
                continue;
            }
            if (dfs(s, len, cur, cur + pre, i + 1, k + 1)) {
                return true;
            }
        }
        return false;
    }

    private long isValid(String s, int l, int r) {
        if (l < r && s.charAt(l) == '0') {
            return -1;
        }
        long res = 0;
        while (l <= r) {
            res = res * 10 + s.charAt(l) - '0';
            l++;
        }
        return res;
    }
}
