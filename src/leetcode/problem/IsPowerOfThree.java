package leetcode.problem;

import java.util.regex.Pattern;

public class IsPowerOfThree {
    /**
     * 326. 3的幂
     * https://leetcode-cn.com/problems/power-of-three/
     */
    public boolean isPowerOfThree(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }
}
