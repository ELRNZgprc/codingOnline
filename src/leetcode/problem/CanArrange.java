package leetcode.problem;

public class CanArrange {
    /**
     * 1497. 检查数组对是否可以被 k 整除
     * https://leetcode-cn.com/problems/check-if-array-pairs-are-divisible-by-k/
     */
    public boolean canArrange(int[] arr, int k) {
        int[] hash = new int[k];
        for (int a : arr) {
            a %= k;
            if (a < 0) {
                a += k;
            }
            hash[a]++;
        }
        if (hash[0] % 2 != 0) {
            return false;
        }
        if ((k % 2 == 0) && (hash[(k) / 2] % 2 != 0)) {
            return false;
        }
        for (int i = 1; i < k / 2.0; i++) {
            if (hash[i] != hash[k - i]) {
                return false;
            }
        }
        return true;
    }
}
