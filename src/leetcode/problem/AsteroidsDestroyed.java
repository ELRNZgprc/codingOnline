package leetcode.problem;

import java.util.Arrays;

/**
 * 2126. 摧毁小行星
 * https://leetcode-cn.com/problems/destroying-asteroids/
 */
public class AsteroidsDestroyed {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m = mass;
        for (int as : asteroids) {
            if (as > m) {
                return false;
            }
            m += as;
        }
        return true;
    }
}
