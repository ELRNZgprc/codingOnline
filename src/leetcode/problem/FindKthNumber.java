package leetcode.problem;

/**
 * 668. 乘法表中第k小的数
 * https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table/
 */
public class FindKthNumber {
    public int findKthNumber(int m, int n, int k) {
        int l = 1, r = m * n;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (countLess(m, n, mid) < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
            if (l == r - 1) {
                if (countLess(m, n, l) >= k) {
                    r = l;
                }
                break;
            }
        }
        return r;
    }

    public int countLess(int m, int n, int max) {
        int ans = 0;
        int r = m;
        for (int i = 1; i <= n; i++) {
            while (r >= 1 && i * r > max) {
                r--;
            }
            ans += r;
        }
        return ans;
    }
}
