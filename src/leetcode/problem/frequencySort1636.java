package leetcode.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1636. 按照频率将数组升序排序
 * https://leetcode-cn.com/problems/sort-array-by-increasing-frequency/
 */
public class frequencySort1636 {
    public int[] frequencySort(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            list.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        list.sort((a, b) -> {
            return map.get(a) == map.get(b) ? b - a : map.get(a) - map.get(b);
        });
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
