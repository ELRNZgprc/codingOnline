package leetcode.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 599. 两个列表的最小索引总和
 * https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/
 */
public class FindRestaurant {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int min = Integer.MAX_VALUE;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                if (i + map.get(list2[i]) < min) {
                    min = i + map.get(list2[i]);
                    ans.clear();
                    ans.add(list2[i]);
                } else if (i + map.get(list2[i]) == min) {
                    ans.add(list2[i]);
                }
            }
        }
        return (String[]) ans.toArray(new String[ans.size()]);
    }
}
