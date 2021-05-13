package leetcode.problem;

/**
 * 1550. 存在连续三个奇数的数组
 * https://leetcode-cn.com/problems/three-consecutive-odds/
 */
public class ThreeConsecutiveOdds {
    public boolean threeConsecutiveOdds(int[] arr) {
        int flag = 0;
        for (int a : arr) {
            if (a % 2 == 1) {
                flag++;
                if (flag == 3) {
                    return true;
                }
            } else {
                flag = 0;
            }
        }
        return false;
    }
}
