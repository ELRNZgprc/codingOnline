package leetcode.problem;

import java.util.Arrays;

/**
 * 932. 漂亮数组
 * https://leetcode.cn/problems/beautiful-array/
 */
public class BeautifulArray {
    public int[] beautifulArray(int N) {
        int[] a = new int[N];
        Arrays.fill(a, 1);
        part(a, 0, N - 1);
        return a;
    }

    public void part(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        part(a, lo, mid);
        part(a, mid + 1, hi);
        for (int i = lo; i <= mid; i++) {
            a[i] = 2 * a[i] - 1;
        }
        for (int i = mid + 1; i <= hi; i++) {
            a[i] = 2 * a[i];
        }
    }
}
