package leetcode.problem;

/**
 * 2169. 得到 0 的操作数
 * https://leetcode.cn/problems/count-operations-to-obtain-zero/
 */
public class CountOperations {
    public int countOperations(int num1, int num2) {
        int ans = 0;
        while (num1 != 0 && num2 != 0) {
            ans++;
            if (num1 >= num2) {
                num1 -= num2;
            } else {
                num2 -= num1;
            }
        }
        return ans;
    }
}
