package leetcode.problem;

public class SumZero {
    /**
     * 1304. 和为零的N个唯一整数
     * https://leetcode-cn.com/problems/find-n-unique-integers-sum-up-to-zero/
     */
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = i - (n - 1) / 2;
        }
        if (n % 2 == 0) {
            ans[0] -= n / 2;
        }
        return ans;
    }
}
