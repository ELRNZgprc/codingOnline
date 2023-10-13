package leetcode.problem;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 1488. 避免洪水泛滥
 * https://leetcode.cn/problems/avoid-flood-in-the-city/
 */
public class AvoidFlood {
    public int[] avoidFlood(int[] rains) {
        int[] res = new int[rains.length];
        Map<Integer, Integer> lastRain = new HashMap<>();
        TreeSet<Integer> pump = new TreeSet<>();

        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                pump.add(i);
            } else {
                res[i] = -1;
                if (!lastRain.containsKey(rains[i])) {
                    lastRain.put(rains[i], i);
                } else {
                    res[i] = -1;
                    int last = lastRain.get(rains[i]);
                    Integer pumpDay = pump.ceiling(last);
                    if (pumpDay == null) {
                        return new int[]{};
                    }
                    res[pumpDay] = rains[i];
                    pump.remove(pumpDay);
                    lastRain.put(rains[i], i);
                }
            }
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 0) {
                res[i] = 1;
            }
        }
        return res;
    }
}
