package leetcode.problem;

import java.util.*;

/**
 * 957. N 天后的牢房
 * https://leetcode-cn.com/problems/prison-cells-after-n-days/
 */
public class PrisonAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<Integer, int[]> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        int[] temp = next(cells);
        for (int i = 1; i <= N; i++) {
            String key = Arrays.toString(temp);
            if (set.contains(key)) break;
            set.add(key);
            map.put(i, temp);
            temp = next(temp);
        }
        int period = set.size();
        int day = N % period;
        return map.get(day == 0 ? period : day);
    }

    private int[] next(int[] cur) {
        int[] res = new int[8];
        for (int i = 1; i < 7; i++) {
            res[i] = (cur[i - 1] ^ cur[i + 1]) == 0 ? 1 : 0;
        }
        return res;
    }
}
