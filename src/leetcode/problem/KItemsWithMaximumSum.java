package leetcode.problem;

/**
 * 2600. K 件物品的最大和
 * https://leetcode.cn/problems/k-items-with-the-maximum-sum/
 */
public class KItemsWithMaximumSum {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= numOnes) {
            return k;
        }
        if (k <= numOnes + numZeros) {
            return numOnes;
        }
        return numOnes - (k - numOnes - numZeros);
    }
}
