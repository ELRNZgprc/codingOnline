package leetcode.problem;

/**
 * 1829. 每个查询的最大异或值
 * https://leetcode.cn/problems/maximum-xor-for-each-query/
 */
public class GetMaximumXor {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int len = nums.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            //前缀异或
            if (i > 0) nums[i] ^= nums[i - 1];
            //倒序插入
            ans[len - i - 1] = nums[i] ^ (int) (Math.pow(2, maximumBit) - 1);
        }
        return ans;
    }
}