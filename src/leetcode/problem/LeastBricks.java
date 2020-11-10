package leetcode.problem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeastBricks {
	/**
	 * 554. 砖墙
	 * https://leetcode-cn.com/problems/brick-wall/
	 */
	public int leastBricks(List<List<Integer>> wall) {
		Map<Integer, Integer> map = new HashMap<>();
        int sum, size = wall.size(), min = size;
        for (List<Integer> w : wall) {
            sum = 0;
            for (int i = 0; i < w.size() - 1; i++) {
                sum += w.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        for (int m : map.values()) 
            min = Math.min(min, size - m);
        return min;
    }
}
