package leetcode.problem;

/**
 * 1220. 统计元音字母序列的数目
 * https://leetcode-cn.com/problems/count-vowels-permutation/
 */
public class CountVowelPermutation {
    public int countVowelPermutation(int n) {
        int M = 1000000007;
        long a = 1, e = 1, i = 1, o = 1, u = 1;
        for (int k = 2; k <= n; k++) {
            long aa = (e + i + u) % M;
            long ee = (a + i) % M;
            long ii = (e + o) % M;
            long oo = i;
            long uu = (o + i) % M;
            a = aa;
            e = ee;
            i = ii;
            o = oo;
            u = uu;
        }
        return (int) ((a + e + i + o + u) % M);
    }
}
