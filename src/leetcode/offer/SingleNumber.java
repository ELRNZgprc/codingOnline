package leetcode.offer;

/**
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int[] dig = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                dig[j] += (num >> j & 1) == 1 ? 1 : 0;
            }
        }
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            ans = ans * 2 + ((dig[i] % 3 == 0) ? 0 : 1);
        }
        return ans;
    }
}
