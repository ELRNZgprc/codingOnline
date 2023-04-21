package leetcode.problem;

/**
 * 2413. 最小偶倍数
 * https://leetcode.cn/problems/smallest-even-multiple/
 */
public class SmallestEvenMultiple {
    public int smallestEvenMultiple(int n) {
        return n<<(n&1);
    }
}
