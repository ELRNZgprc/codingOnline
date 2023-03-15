package leetcode.problem;

/**
 * 1822. 数组元素积的符号
 * https://leetcode.cn/problems/sign-of-the-product-of-an-array/
 */
public class ArraySign {
    public int arraySign(int[] nums) {
        int flag = 1;
        for (int num : nums) {
            if (num < 0) {
                flag = -flag;
            }
            if (num == 0) {
                return 0;
            }
        }
        return flag;
    }
}
