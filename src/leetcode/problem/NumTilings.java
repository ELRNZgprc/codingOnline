package leetcode.problem;

/**
 * 790. 多米诺和托米诺平铺
 * https://leetcode.cn/problems/domino-and-tromino-tiling/
 */
public class NumTilings {
    public int numTilings(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 5;
        }
        int n1 = 1;
        int n2 = 2;
        int n3 = 5;
        int temp = 0;
        for (int i = 4; i <= n; i++) {
            temp = (2 * n3) % 1000000007 + n1 % 1000000007;
            n1 = n2;
            n2 = n3;
            n3 = temp % 1000000007;
        }
        return n3;
    }
}
