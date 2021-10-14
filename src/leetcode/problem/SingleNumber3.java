package leetcode.problem;

/**
 * 260. 只出现一次的数字 III
 * https://leetcode-cn.com/problems/single-number-iii/
 */
public class SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        int total = 0;
        for (int n : nums) {
            total ^= n;
        }
        int i = 0;
        while (((total >> i) & 1) != 1) {
            i++;
        }
        int[] ans = new int[2];
        for (int n : nums) {
            ans[(n >> i) & 1] ^= n;
        }
        return ans;
    }
}
