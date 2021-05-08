package leetcode.problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 970. 强整数
 * https://leetcode-cn.com/problems/powerful-integers/
 */
public class PowerfulIntegers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> ansSet = new HashSet<>();

        for (int i = 1; i < bound; i *= x) {
            for (int j = 1; j + i <= bound; j *= y) {
                ansSet.add(i + j);
                if (y == 1) break;
            }
            if (x == 1) break;
        }
        return new ArrayList<>(ansSet);
    }
}
