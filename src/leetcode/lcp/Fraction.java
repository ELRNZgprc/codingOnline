package leetcode.lcp;

/**
 * LCP 02. 分式化简
 * https://leetcode.cn/problems/deep-dark-fraction/
 */
public class Fraction {
    public int[] fraction(int[] cont) {
        int m = 1;// 分子
        int n = cont[cont.length - 1];// 分母
        int[] res = new int[2];
        for (int i = cont.length - 2; i > 0; i--) {
            m = n * cont[i] + m;
            int temp = n;
            n = m;
            m = temp;

        }
        if (cont.length == 1) {
            return new int[]{cont[0], 1};
        }
        m = n * cont[0] + m;
        res[0] = m;
        res[1] = n;
        return res;
    }
}
