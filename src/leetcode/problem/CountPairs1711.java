package leetcode.problem;

import java.util.HashMap;

/**
 * 1711. 大餐计数
 * https://leetcode.cn/problems/count-good-meals/
 */
public class CountPairs1711 {
    public int countPairs(int[] deliciousness) {
        int max = 1 << 22;
        long mod = (int) 1e9 + 7;
        long ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : deliciousness) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int d : map.keySet()) {
            for (int i = 1; i < max; i <<= 1) {
                int t = i - d;
                if (map.containsKey(t)) {
                    if (d == t) {
                        ans += ((long) (map.get(d) - 1)) * ((long) map.get(d)) / 2 % mod;
                        ans %= mod;
                    } else if (d < t) {
                        ans += ((long) map.get(t)) * ((long) map.get(d)) % mod;
                        ans %= mod;
                    }
                }
            }
        }
        return (int) (ans % mod);
    }
}
