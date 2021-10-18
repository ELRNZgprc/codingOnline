package leetcode.problem;

/**
 * 1835. 所有数对按位与结果的异或和
 * https://leetcode-cn.com/problems/find-xor-sum-of-all-pairs-bitwise-and/
 */
public class GetXORSum {
    public int getXORSum(int[] arr1, int[] arr2) {
        int a = 0;
        int b = 0;
        for (int n : arr1) {
            a ^= n;
        }
        for (int n : arr2) {
            b ^= n;
        }
        return a & b;
    }
}
