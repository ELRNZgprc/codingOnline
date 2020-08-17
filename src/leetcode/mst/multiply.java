package leetcode.mst;

public class multiply {
    /**
     * 面试题 08.05
     * https://leetcode-cn.com/problems/recursive-mulitply-lcci/
     */
    public int multiply(int A, int B) {
        if (B == 0) {
            return 0;
        }
        return A + multiply(A, B - 1);
    }
}
