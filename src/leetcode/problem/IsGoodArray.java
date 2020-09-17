package leetcode.problem;

public class IsGoodArray {
    /**
     * 1250. 检查「好数组」
     * https://leetcode-cn.com/problems/check-if-it-is-a-good-array/
     */
    public boolean isGoodArray(int[] nums) {
        int gcd = nums[0];
        for (int i = 1; i < nums.length; i++) {
            gcd = gcd(gcd, nums[i]);
        }
        return gcd == 1;
    }

    int gcd(int a, int b) {
        int x = a;
        int y = b;
        while (x % y != 0) {
            int z = x % y;
            x = y;
            y = z;
        }
        return y;
    }
}
