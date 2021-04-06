package leetcode.problem;

import java.util.HashMap;

/**
 * 914. 卡牌分组
 * https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/
 */
public class HasGroupsSizeX {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : deck) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Integer[] counts = map.values().toArray(new Integer[0]);

        int x = 0;
        for (int cnt : counts) {
            x = gcd(x, cnt);
            if (x == 1) {
                return false;
            }
        }
        return x >= 2;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
