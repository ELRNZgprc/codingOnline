package leetcode.problem;

/**
 * 1780. 判断一个数字是否可以表示成三的幂的和
 * https://leetcode-cn.com/problems/check-if-number-is-a-sum-of-powers-of-three/
 */
public class CheckPowersOfThree {
    public boolean checkPowersOfThree(int n) {
        while (n > 1) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}
